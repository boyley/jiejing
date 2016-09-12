package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.domains.Keeplive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lenovo on 2016/9/12.
 */
public interface KeepliveRepository  extends JpaRepository<Keeplive, Integer>, JpaSpecificationExecutor<Keeplive> {
}
