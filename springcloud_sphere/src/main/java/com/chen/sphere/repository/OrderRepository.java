package com.chen.sphere.repository;

import com.chen.sphere.dataobject.OrderDo;
import com.chen.sphere.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author 26050
 * @Date 2023/5/31 22:14
 * @Version 1.0
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    public int saveOrUpdate(OrderDo orderDo){
        return orderMapper.insert(orderDo);
    }
}
