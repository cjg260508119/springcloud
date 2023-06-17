package com.chen.sphere.service;

import com.chen.sphere.dataobject.OrderDo;
import com.chen.sphere.mapper.OrderMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 26050
 * @Date 2023/5/31 22:12
 * @Version 1.0
 */
public interface IOrderService {

    public int saveOrUpdate(OrderDo orderDo);
}
