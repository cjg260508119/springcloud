package com.chen.rabbitmq.config;

import com.chen.rabbitmq.cons.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:RabbitConfig
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/15 22:55
 * @Version: v1.0
 */
@Configuration
public class RabbitConfig {

    // 创建 Queue
    @Bean
    public Queue demo01Queue() {
        return new Queue(RabbitConstant.Demo01_QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo01Exchange() {
        return new DirectExchange(RabbitConstant.Demo01_EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Binding
    // Exchange：Demo01Message.EXCHANGE
    // Routing key：Demo01Message.ROUTING_KEY
    // Queue：Demo01Message.QUEUE
    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(RabbitConstant.Demo01_ROUTING_KEY);
    }
}
