package com.jiejing.locker.service;

import com.jiejing.locker.domains.ChargeStandard;
import com.jiejing.locker.service.dto.BoxSize;

import java.util.List;
import java.util.Optional;

/**
 * Created by lenovo on 2016/9/9.
 */
public interface IChargeStandardService {

    /**
     * 获取规则的规格收费信息列表
     * @param cabinetId
     * @return
     */
    List<BoxSize> findBoxSize(int cabinetId);

    ChargeStandard findOne(int id);

    Optional<ChargeStandard> findOneById(int id);
}
