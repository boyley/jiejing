package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Region;
import com.jiejing.locker.repository.RegionRepository;
import com.jiejing.locker.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/9/12.
 */
@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public boolean exists(Integer id) {
        return regionRepository.exists(id);
    }

    @Override
    public Region findOne(Integer regionId) {
        return regionRepository.findOne(regionId);
    }
}
