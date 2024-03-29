package com.chen.rabbitmq.test.client;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:RabbitMQProducer
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/17 10:39
 * @Version: v1.0
 */
public class RabbitMQProducer {
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final Integer PORT = 5672;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "cjg260508119";

    private static final String EXCHANGE_NAME = "exchange_demo1";
    private static final String ROUTING_KEY = "routingkey_demo1";
    public static final String QUEUE_NAME = "queue_demo1"; // 只有 QUEUE_NAME 需要共享给 RabbitMQConsumer

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
            builder.expiration("10000");
            builder.deliveryMode(2);
            builder.contentType("text/plain");
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, mandatory, builder.build(), message.getBytes());

        }

        /*try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
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

    // 创建 RabbitMQ Exchange 和 Queue ，然后使用 ROUTING_KEY 路由键将两者绑定。
    // 该步骤，其实可以在 RabbitMQ Management 上操作，并不一定需要在代码中
    private static void initExchangeAndQueue(Channel channel) throws IOException {
        // 创建交换器：direct、持久化、不自动删除
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);

        // 创建队列：持久化、非排他、非自动删除的队列
        //设置ttl过期时间（通过队列的方式）
        Map<String, Object> argss = new HashMap<>();
        //时间为毫秒
        //argss.put("x-message-ttl", 5000);
        channel.queueDeclare(QUEUE_NAME, true, false, false, argss);

        // 将交换器与队列通过路由键绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
    }
}
