package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/8.
 */
public interface BoxRepository extends JpaRepository<Box, Integer>, JpaSpecificationExecutor<Box> {

    Optional<Box> findOneById(int id);
}
