package com.jiejing.locker.service;

import com.jiejing.locker.domains.Dictionary;

import java.util.Optional;

/**
 * Created by lenovo on 2016/9/10.
 */
public interface IDictionaryService {

    Optional<Dictionary> findOneByCode(String code);
}
