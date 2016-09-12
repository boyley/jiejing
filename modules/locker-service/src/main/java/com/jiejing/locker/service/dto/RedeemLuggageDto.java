package com.jiejing.locker.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.domains.LeaseInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lenovo on 2016/9/10.
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedeemLuggageDto {

    private Integer cabinetId;//柜子id
    private LeaseInfo leaseInfo;//取箱资料
}
