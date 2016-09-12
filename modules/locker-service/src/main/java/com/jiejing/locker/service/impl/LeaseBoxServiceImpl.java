package com.jiejing.locker.service.impl;

import com.jiejing.locker.config.Constants;
import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.domains.LeaseBox_;
import com.jiejing.locker.domains.LeaseInfo_;
import com.jiejing.locker.repository.LeaseBoxRepository;
import com.jiejing.locker.service.ILeaseBoxService;
import com.jiejing.locker.service.dto.RedeemLuggageDto;
import com.jiejing.locker.util.SpecificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2016/9/9.
 */
@Service
public class LeaseBoxServiceImpl implements ILeaseBoxService {

    @Autowired
    private LeaseBoxRepository leaseBoxRepository;

    @Override
    public LeaseBox save(LeaseBox leaseBox) {
        return leaseBoxRepository.save(leaseBox);
    }

    @Override
    public List<LeaseBox> findAdvisableLeaseBox(RedeemLuggageDto redeemLuggage) {
        return leaseBoxRepository.findAll((root, query, cb) -> {
            List<Predicate> precs = new ArrayList<>();
            precs.add(cb.equal(root.get(LeaseBox_.cabinetId), redeemLuggage.getCabinetId()));//柜子id
            precs.add(cb.equal(root.get(LeaseBox_.boxState), Constants.BoxState.DQ));//状态：DQ
            precs.add(cb.equal(root.join(LeaseBox_.leaseInfos).get(LeaseInfo_.code), redeemLuggage.getLeaseInfo().getCode())); //证件类型
//            precs.add(cb.equal(root.join(LeaseBox_.leaseInfos).join(LeaseInfo_.) ));
            return cb.and(SpecificationUtil.toPredicateArray(precs));
        });
    }
}
