package com.jiejing.locker.web.rest;

import com.jiejing.locker.config.Constants;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.exception.BadException;
import com.jiejing.locker.service.ICabinetService;
import com.jiejing.locker.web.rest.view.HeaderUtil;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by lenovo on 2016/9/12.
 */
@RestController
@RequestMapping("api/cabinet")
public class CabinetResource {

    @Autowired
    private ICabinetService cabinetService;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Cabinet cabinet) {
        if (ObjectUtils.isEmpty(cabinet.getBoxs())) throw new BadException("boxs必传");
        if (ObjectUtils.isEmpty(cabinet.getRegionId())) throw new BadException("regionId 必传");
        if (ObjectUtils.isEmpty(cabinet.getOpenTime())) throw new BadException("openTime 必传");
        if (ObjectUtils.isEmpty(cabinet.getCloseTime())) throw new BadException("closeTime 必传");
        if (ObjectUtils.isEmpty(cabinet.getCode())) throw new BadException("code 必传");

        cabinet.setStatus(Constants.Status.ENABLE);// 状态启用
        cabinet.setVoucherVerify(true);// 是否证件验证
        cabinet.setMultiple(false);//可多次使用
        cabinet.getBoxs().stream().forEach(e -> {
            if (ObjectUtils.isEmpty(e.getCode())) throw new BadException(" box.code 必传");
            if (ObjectUtils.isEmpty(e.getBoxSizeCode())) throw new BadException(" box.boxSizeCode 必传");

            if (ObjectUtils.isEmpty(e.getStatus()))
                e.setStatus(Constants.Status.ENABLE);//是否禁用: ENABLE:启用
            if (ObjectUtils.isEmpty(e.getGateLockState()))
                e.setGateLockState(Constants.GateLockState.CLOSE);//门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常
            if (ObjectUtils.isEmpty(e.getDepositState()))
                e.setDepositState(Constants.DepositState.N);//存物状态Y:有存物，N：无存物，ERROR：异常,ZY:占用
        });
        this.cabinetService.save(cabinet);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/cabinet/" + cabinet.getId()).build().toUri())
                .headers(HeaderUtil.createAlert("order.created", cabinet.getId()))
                .body(new Response<>(cabinet));
    }

}
