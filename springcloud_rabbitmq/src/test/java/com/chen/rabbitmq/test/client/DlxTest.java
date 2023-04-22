package com.chen.rabbitmq.test.client;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:DlxTest
 * @Auther: 26050
 * @Description: 测试死信队列
 * @Date: 2023/4/19 18:56
 * @Version: v1.0
 */
public class DlxTest {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final Integer PORT = 5672;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "cjg260508119";
    private static final String EXCHANGE_NORMAL_NAME = "exchange_normal_demo";
    public static final String QUEUE_NOMARL_NAME = "queue_normal_demo";
    private static final String ROUTING_NORMAL_KEY = "routingkey_normal_demo";

    private static final String EXCHANGE_DLX_NAME = "exchange_dlx_demo";
    public static final String QUEUE_DLX_NAME = "queue_dlx_demo";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        Connection connection = getConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 初始化测试用的 Exchange 和 Queue
        initExchangeAndQueue(channel);
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(replyText);
            }
        });
        for (int i = 0; i < 3; i++) {
            String message = "Hello World" + i;
            /**
             * 使用mandatory参数发布，如果为true时，交换机无法通过路由键找到队列的时候，会通过Basic.Return命令把消息返回给生产者，如果为false则直接丢弃
             * rabbitmq3.0被去掉了
             * */
            boolean mandatory = true;
            //单条消息设置失效时间
            /*AMQP.BasicProperties basic = new AMQP.BasicProperties("text/plain",
                    null,
                    null,
                    2,
                    0, null, null, null,
                    null, null, null, null,
                    null, null);*/
            AMQP.BasicProperties.Builder builder =  new AMQP.BasicProperties.Builder();
            //builder.expiration("10000");
            builder.deliveryMode(2);
            builder.contentType("text/plain");
            channel.basicPublish(EXCHANGE_NORMAL_NAME, ROUTING_NORMAL_KEY, mandatory, builder.build(), message.getBytes());

        }
        // 关闭
        channel.close();
        connection.close();
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        return factory.newConnection();
    }

    private static void initExchangeAndQueue(Channel channel) throws IOException {
        // 创建死信交换器：direct、持久化、不自动删除
        channel.exchangeDeclare(EXCHANGE_DLX_NAME, "direct", true, false, null);
        //创建死信队列
        channel.queueDeclare(QUEUE_DLX_NAME, true, false, false, null);
        channel.queueBind(QUEUE_DLX_NAME, EXCHANGE_DLX_NAME, ROUTING_NORMAL_KEY);

        // 创建交换器：direct、持久化、不自动删除
        channel.exchangeDeclare(EXCHANGE_NORMAL_NAME, "direct", true, false, null);
        // 创建队列：持久化、非排他、非自动删除的队列
        //设置ttl过期时间（通过队列的方式）
        Map<String, Object> argss = new HashMap<>();
        //时间为毫秒
        argss.put("x-message-ttl", 5000);
        argss.put("x-dead-letter-exchange", EXCHANGE_DLX_NAME);
        argss.put("x-dead-letter-routing-key", ROUTING_NORMAL_KEY);
        channel.queueDeclare(QUEUE_NOMARL_NAME, true, false, false, argss);
        // 将交换器与队列通过路由键绑定
        channel.queueBind(QUEUE_NOMARL_NAME, EXCHANGE_NORMAL_NAME, ROUTING_NORMAL_KEY);


    }
}
