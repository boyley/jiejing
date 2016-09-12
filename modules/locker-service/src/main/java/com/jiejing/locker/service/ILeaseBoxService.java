package com.jiejing.locker.service;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.service.dto.RedeemLuggageDto;

import java.util.List;

/**
 * Created by lenovo on 2016/9/9.
 */
public interface ILeaseBoxService {
    LeaseBox save(LeaseBox leaseBox);

    /**
     * 获取柜子存放记录
     *
     * @param redeemLuggage
     * @return
     */
    List<LeaseBox> findAdvisableLeaseBox(RedeemLuggageDto redeemLuggage);
}
