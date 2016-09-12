package com.jiejing.locker.service;

import com.jiejing.locker.domains.Order;

import java.util.Optional;

/**
 * Created by lenovo on 2016/9/9.
 */
public interface IOrderService {

    /**
     * 创建订单
     *
     * @return
     */
    Order create(Order order);

    Optional<Order> findOne(Integer id);
}
