package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lenovo on 2016/9/12.
 */
public interface CabinetRepository extends JpaRepository<Cabinet, Integer>, JpaSpecificationExecutor<Cabinet> {
}
