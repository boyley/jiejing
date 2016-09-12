package com.jiejing.locker.service;

import com.jiejing.locker.service.dto.RedeemLuggageDto;

import java.util.List;

/**
 * Created by lenovo on 2016/9/10.
 */
public interface IRedeemLuggageService {

    /**
     * 取箱
     *
     * @param redeemLuggage
     * @return
     */
    List<RedeemLuggageDto> redeemLuggage(RedeemLuggageDto redeemLuggage);
}
