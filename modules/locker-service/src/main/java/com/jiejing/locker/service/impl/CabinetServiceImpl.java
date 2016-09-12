package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.domains.Dictionary;
import com.jiejing.locker.domains.Region;
import com.jiejing.locker.exception.BizException;
import com.jiejing.locker.repository.CabinetRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.service.ICabinetService;
import com.jiejing.locker.service.IDictionaryService;
import com.jiejing.locker.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/12.
 */
@Service
public class CabinetServiceImpl implements ICabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Autowired
    private IBoxService boxService;

    @Autowired
    private IRegionService regionService;

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 保存柜子信息
     * 1. 查询柜子地理位置是否存在
     * 2. 保存柜子
     * 3. 关联箱子的柜子id
     *
     * @param cabinet
     * @return
     */
    @Override
    @Transactional
    public Optional<Cabinet> save(Cabinet cabinet) {
        // 查询柜子地理位置是否正确
        Integer regionId = cabinet.getRegionId();
        Region region = regionService.findOne(regionId);
        if (region == null) {
            throw new BizException("地理位置id：" + regionId + "不存在");
        }
        cabinet.getBoxs().forEach(e -> {
            String boxSizeCode = e.getBoxSizeCode();
            Dictionary dictionary = dictionaryService.findOneByCode(boxSizeCode).orElseThrow(() -> new BizException("无可用的规格"));
            e.setBoxSizeCode(dictionary.getCode());
            e.setBoxSize(dictionary);
        });

        cabinet.setRegionId(region.getId());
        this.cabinetRepository.save(cabinet);
        return Optional.ofNullable(cabinet);
    }

    @Override
    public Optional<Cabinet> findOne(Integer id) {
        return Optional.ofNullable(this.cabinetRepository.findOne(id));
    }
}
