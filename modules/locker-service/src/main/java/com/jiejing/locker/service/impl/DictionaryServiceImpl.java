package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Dictionary;
import com.jiejing.locker.repository.DictionaryRepository;
import com.jiejing.locker.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lenovo on 2016/9/10.
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    public Optional<Dictionary> findOneByCode(String code) {
        return dictionaryRepository.findByCode(code);
    }
}
