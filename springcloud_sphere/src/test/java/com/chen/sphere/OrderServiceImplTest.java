package com.chen.sphere;

import com.chen.sphere.dataobject.OrderDo;
import com.chen.sphere.repository.OrderRepository;
import com.chen.sphere.service.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 26050
 * @Date 2023/5/31 22:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    //@Autowired
    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    @Test
    public void testSave(){
        OrderDo orderDo = new OrderDo();
        orderDo.setUserId(10000);
        when(orderRepository.saveOrUpdate(orderDo)).thenReturn(10);
        System.out.println(orderServiceImpl.saveOrUpdate(orderDo));
    }
}
