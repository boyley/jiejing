package com.jiejing.locker.repository;

import com.jiejing.locker.domains.RedeemLuggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Bogle on 2016/9/8.
 */
public interface RedeemLuggageRepository extends JpaRepository<RedeemLuggage, Integer>, JpaSpecificationExecutor<RedeemLuggage> {

}
