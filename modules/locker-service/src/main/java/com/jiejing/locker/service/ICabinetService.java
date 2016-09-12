package com.jiejing.locker.service;

import com.jiejing.locker.domains.Cabinet;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/12.
 */
public interface ICabinetService {

    /**
     * 保存柜子信息
     *
     * @param cabinet
     */
    Optional<Cabinet> save(Cabinet cabinet);

    Optional<Cabinet> findOne(Integer id);

}
