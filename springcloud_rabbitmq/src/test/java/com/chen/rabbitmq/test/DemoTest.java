package com.chen.rabbitmq.test;

import com.chen.rabbitmq.cons.RabbitConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName:DemoTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/15 22:50
 * @Version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        rabbitTemplate.convertAndSend(RabbitConstant.Demo01_EXCHANGE, RabbitConstant.Demo01_ROUTING_KEY, "message");
    }
}
