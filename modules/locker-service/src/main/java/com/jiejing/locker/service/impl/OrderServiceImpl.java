package com.jiejing.locker.service.impl;

import com.jiejing.locker.config.Constants;
import com.jiejing.locker.domains.*;
import com.jiejing.locker.exception.BizException;
import com.jiejing.locker.repository.OrderRepository;
import com.jiejing.locker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by lenovo on 2016/9/9.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IBoxService boxService;

    @Autowired
    private IChargeStandardService chargeStandardService;

    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Autowired
    private IDictionaryService dictionaryService;

    @Override
    @Transactional
    public Order create(final Order order) {
        order.setOrderNum(this.orderNumber()); // 订单号
        order.setOrderState(Constants.OrderState.DZF);//订单状态：DZF(待支付)
        final LeaseBox leaseBox = order.getLeaseBox();
        return Optional.ofNullable(orderRepository.save(order)).map(e -> {
            // 柜子,箱子
            Box box = boxService.findOneById(leaseBox.getBoxId())
                    .orElseThrow(() -> new BizException("箱子不存在"));
            //柜子
            Cabinet cabinet = box.getCabinet();
            leaseBox.setCabinetId(cabinet.getId());
            leaseBox.setCabinetCode(cabinet.getCode());
            leaseBox.setCabinetName(cabinet.getName());
            //箱子
            leaseBox.setBoxId(box.getId());
            leaseBox.setBoxCode(box.getCode());
            leaseBox.setBoxName(box.getName());
            // 规格
            Dictionary boxSize = box.getBoxSize();
            leaseBox.setBoxSizeId(boxSize.getId());
            leaseBox.setBoxSizeCode(boxSize.getCode());
            leaseBox.setBoxSizeName(boxSize.getName());
            //收费标准
            ChargeStandard cs = this.chargeStandardService.findOneById(leaseBox.getChargeStandardId()).orElseThrow(() -> new BizException("收费标准不存在"));
            leaseBox.setChargeStandardId(cs.getId());
            leaseBox.setChargeType(cs.getChargeType());
            leaseBox.setCycleTime(cs.getCycleTime());
            leaseBox.setPrice(cs.getPrice());
            // 资料类型
            List<LeaseInfo> leaseInfos = leaseBox.getLeaseInfos();//资料信息
            leaseInfos.forEach((leaseInfo) -> {
                Dictionary infoType = this.dictionaryService.findOneByCode(leaseInfo.getCode()).orElseThrow(() -> new BizException("资料类型不存在"));
                leaseInfo.setInfoType(infoType.getId());
                leaseInfo.setName(infoType.getName());
            });

            //其他信息
            leaseBox.setBoxState(Constants.BoxState.ZY);//箱子占用状态
            leaseBox.setOrderId(e.getId()); // 存储记录对应的订单号
            leaseBoxService.save(leaseBox);

            return order;
        }).get();
    }

    @Override
    public Optional<Order> findOne(Integer id) {
        return Optional.ofNullable(this.orderRepository.findOne(id));
    }

    private String orderNumber() {
        return "123456";
    }
}
