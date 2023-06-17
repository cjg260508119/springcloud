package com.chen.sphere.service;

import com.chen.sphere.dataobject.OrderDo;
import com.chen.sphere.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 26050
 * @Date 2023/5/31 22:17
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public int saveOrUpdate(OrderDo orderDo) {
        return orderRepository.saveOrUpdate(orderDo);
    }
}
