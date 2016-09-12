package com.jiejing.locker.service;

import com.jiejing.locker.domains.Keeplive;

import java.util.List;

/**
 * Created by lenovo on 2016/9/12.
 */
public interface IKeepliveService {

    List<Keeplive> save(List<Keeplive> keeplives);
}
