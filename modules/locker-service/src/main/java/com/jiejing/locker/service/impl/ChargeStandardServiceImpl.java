package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.ChargeStandard;
import com.jiejing.locker.repository.ChargeStandardRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.service.IChargeStandardService;
import com.jiejing.locker.service.dto.BoxSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by lenovo on 2016/9/9.
 */
@Service
public class ChargeStandardServiceImpl implements IChargeStandardService {

    @Autowired
    private ChargeStandardRepository chargeStandardRepository;

    @Autowired
    private IBoxService boxService;

    @Override
    @Transactional
    public List<BoxSize> findBoxSize(int cabinetId) {
        return this.chargeStandardRepository.findBoxSize(cabinetId).map(e -> {
            BoxSize boxSize = new BoxSize();
            boxSize.setId((Integer) e[0]);
            boxSize.setBoxSizeId(e[1] != null ? (Integer) e[1] : null);
            boxSize.setCode(e[2] != null ? e[2].toString() : null);
            boxSize.setName(e[3] != null ? e[3].toString() : null);
            boxSize.setPrice(e[4] != null ? new BigDecimal(e[4].toString()) : null);
            boxSize.setDescription(e[5] != null ? e[5].toString() : null);
            boxSize.setEnable(boxService.exists(boxSize.getBoxSizeId()));//查询是否可用
            return boxSize;
        }).collect(Collectors.toList());
    }

    @Override
    public ChargeStandard findOne(int id) {
        return this.chargeStandardRepository.findOne(id);
    }

    @Override
    public Optional<ChargeStandard> findOneById(int id) {
        return Optional.ofNullable(this.findOne(id));
    }
}
