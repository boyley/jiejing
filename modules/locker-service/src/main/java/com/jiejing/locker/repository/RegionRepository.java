package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 */
public interface RegionRepository extends JpaRepository<Region, Integer>, JpaSpecificationExecutor<Region> {

    boolean exists(Integer id);

    Region findOne(Integer regionId);
}
