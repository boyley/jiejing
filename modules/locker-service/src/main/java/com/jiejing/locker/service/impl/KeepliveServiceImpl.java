package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Keeplive;
import com.jiejing.locker.repository.KeepliveRepository;
import com.jiejing.locker.service.IKeepliveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2016/9/12.
 */
@Service
public class KeepliveServiceImpl implements IKeepliveService {

    @Autowired
    private KeepliveRepository keepliveRepository;


    @Override
    public List<Keeplive> save(List<Keeplive> keeplives) {
        return this.keepliveRepository.save(keeplives);
    }
}
