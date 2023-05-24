package com.chen.sphere;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chen.sphere.dataobject.OrderDo;
import com.chen.sphere.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 26050
 * @Date 2023/5/23 16:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperRepositoryTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testSave(){
        OrderDo orderDo = new OrderDo();
        //orderDo.setId(1L);
        orderDo.setUserId(10);
        orderMapper.insert(orderDo);
    }

    @Test
    public void testGet(){
        LambdaQueryWrapper<OrderDo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(OrderDo::getId, "1661011509940641794");
        wrapper.eq(OrderDo::getUserId, 10);
        OrderDo orderDo = orderMapper.selectOne(wrapper);
        System.out.println(orderDo);
    }
}
