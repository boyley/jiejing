package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;

import java.util.Optional;

/**
 * Created by lenovo on 2016/9/9.
 */
public interface IBoxService {

    /**
     * 查询制定规格的箱子是否有可用的箱子
     *
     * @param boxSizeId
     * @return
     */
    boolean exists(int boxSizeId);

    Optional<Box> findOneById(int id);
}
