package com.jiejing.locker.service.impl;

import com.jiejing.locker.config.Constants;
import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.Box_;
import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.util.SpecificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by lenovo on 2016/9/9.
 */
@Service
public class BoxServiceImpl implements IBoxService {

    @Autowired
    private BoxRepository boxRepository;

    @Override
    public boolean exists(int boxSizeId) {
        List<Box> boxes = boxRepository.findAll((root, query, cb) -> {
            List<Predicate> pres = new ArrayList<>();
            pres.add(cb.equal(root.get(Box_.boxSize), boxSizeId));// 箱子大小
            pres.add(cb.equal(root.get(Box_.depositState), Constants.DepositState.N)); // 无存物
            pres.add(cb.equal(root.get(Box_.status), Constants.Status.ENABLE));//状态可用
            pres.add(cb.notEqual(root.get(Box_.gateLockState), Constants.GateLockState.ERROR));// 门状态不为异常情况
            return cb.and(SpecificationUtil.toPredicateArray(pres));
        });
        return boxes == null || boxes.isEmpty() ? false : true;
    }

    @Override
    public Optional<Box> findOneById(int id) {
        return this.boxRepository.findOneById(id);
    }
}
