package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.repository.RedeemLuggageRepository;
import com.jiejing.locker.service.ILeaseBoxService;
import com.jiejing.locker.service.IRedeemLuggageService;
import com.jiejing.locker.service.dto.RedeemLuggageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2016/9/10.
 */
@Service
public class RedeemLuggageServiceImpl implements IRedeemLuggageService {

    @Autowired
    private RedeemLuggageRepository redeemLuggageRepository;

    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Override
    public List<RedeemLuggageDto> redeemLuggage(RedeemLuggageDto redeemLuggage) {
        // 1. 获取柜子存箱记录
        LeaseInfo leaseInfo = redeemLuggage.getLeaseInfo();
        List<LeaseBox> leaseBoxes = leaseBoxService.findAdvisableLeaseBox(redeemLuggage);
        return null;
    }
}
