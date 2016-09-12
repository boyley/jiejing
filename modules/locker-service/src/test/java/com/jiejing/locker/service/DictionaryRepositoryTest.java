package com.jiejing.locker.service;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.domains.LeaseInfoExtra;
import com.jiejing.locker.domains.Order;
import com.jiejing.locker.repository.DictionaryRepository;
import com.jiejing.locker.service.dto.RedeemLuggageDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Bogle on 2016/9/8.
 */
public class DictionaryRepositoryTest extends AbsServiceTest {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private IChargeStandardService chargeStandardService;

    @Autowired
    private IRedeemLuggageService redeemLuggageService;

    @Autowired
    private IOrderService orderService;

    @Test
    public void findBoxSize() {
        printlnJson(this.chargeStandardService.findBoxSize(1));
    }

    @Test
    public void createOrder() {
        Order order = new Order();
        order.setOrderSource(13);//下单渠道
        order.setOrderNum("123456");//订单号
        order.setPrice(new BigDecimal(2000));//付款金额
        LeaseBox leaseBox = new LeaseBox();//存储记录
        leaseBox.setBoxId(5);//箱子规格id
        leaseBox.setCheckType(1);// 模式类型
        leaseBox.setChargeStandardId(2);//箱子收费标准id

        LeaseInfo info1 = new LeaseInfo();
        info1.setCode("SFZ");

        LeaseInfo info2 = new LeaseInfo();
        info2.setCode("HZ");


        LeaseInfoExtra extra1 = new LeaseInfoExtra(); // 证件信息
        extra1.setName("姓名");
        extra1.setValue("张家辉");

        LeaseInfoExtra extra2 = new LeaseInfoExtra(); // 证件信息
        extra2.setName("身份证号");
        extra2.setValue("44444444444444444444444444");


        LeaseInfoExtra extra3 = new LeaseInfoExtra(); // 证件信息
        extra3.setName("姓名");
        extra3.setValue("刘德华");

        LeaseInfoExtra extra4 = new LeaseInfoExtra(); // 证件信息
        extra4.setName("护照号码");
        extra4.setValue("555555555555555555555555555555");

        info1.setLeaseInfoExtras(Arrays.asList(extra1, extra2));
        info2.setLeaseInfoExtras(Arrays.asList(extra3, extra4));
        leaseBox.setLeaseInfos(Arrays.asList(info1,info2));

        order.setLeaseBox(leaseBox);

        printlnJson(orderService.create(order));

    }

    @Test
    public void redeemLuggage() {
        RedeemLuggageDto dto = new RedeemLuggageDto();
        dto.setCabinetId(1);

        LeaseInfo info1 = new LeaseInfo();
        info1.setCode("SFZ");


        LeaseInfoExtra extra1 = new LeaseInfoExtra(); // 证件信息
        extra1.setName("姓名");
        extra1.setValue("张家辉");

        LeaseInfoExtra extra2 = new LeaseInfoExtra(); // 证件信息
        extra2.setName("身份证号");
        extra2.setValue("44444444444444444444444444");

        info1.setLeaseInfoExtras(Arrays.asList(extra1, extra2));
        dto.setLeaseInfo(info1);
        printlnJson(redeemLuggageService.redeemLuggage(dto));
    }

    @Test
    public void findOne() {
        printlnJson(dictionaryRepository.findOne(1));
    }
}
