package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lenovo on 2016/9/9.
 */
public interface LeaseBoxRepository extends JpaRepository<LeaseBox, Integer>, JpaSpecificationExecutor<LeaseBox> {

}
