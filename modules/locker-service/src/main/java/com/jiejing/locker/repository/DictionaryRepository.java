package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/8.
 */
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer>, JpaSpecificationExecutor<Dictionary> {
 
    Optional<Dictionary> findByCode(String code);
}
