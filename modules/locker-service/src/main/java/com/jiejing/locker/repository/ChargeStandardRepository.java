package com.jiejing.locker.repository;

import com.jiejing.locker.domains.ChargeStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/9/8.
 */
public interface ChargeStandardRepository extends JpaRepository<ChargeStandard, Integer>, JpaSpecificationExecutor<ChargeStandard> {

    /**
     * 根据cabinetId获取箱子规格列表
     *
     * @param cabinetId
     * @return
     */
//    @Query(nativeQuery = true, value = "SELECT DISTINCT DISTINCT locker_charge_standard.id, locker_box.box_size_id box_size_id,sys_dictionary.`code`,sys_dictionary.`name`,locker_charge_standard.price, sys_dictionary.description FROM locker_box_charge_standard INNER JOIN locker_box ON locker_box.id = locker_box_charge_standard.box_id INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id INNER JOIN locker_charge_standard ON locker_charge_standard.id = locker_box_charge_standard.charge_standard_id INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id WHERE locker_box.cabinet_id=:cabinetId UNION SELECT DISTINCT locker_charge_standard.id, locker_box.box_size_id box_size_id, sys_dictionary.`code`, sys_dictionary.`name`, locker_charge_standard.price, sys_dictionary.description from locker_box INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id INNER JOIN locker_charge_standard ON  locker_charge_standard.default_box_size = locker_box.box_size_id WHERE locker_box.id NOT in (select box_id from locker_box_charge_standard) and locker_box.cabinet_id=:cabinetId")
    @Query(nativeQuery = true,value =
            "SELECT  cs.id id, sys_dictionary.id boxSizeId, sys_dictionary.`code` code, sys_dictionary.`name` name, cs.price price, sys_dictionary.description description from  locker_charge_standard cs LEFT JOIN locker_cabinet_charge_standard ccs ON ccs.charge_standard_id = cs.id INNER JOIN sys_dictionary ON sys_dictionary.id = ccs.box_size_id WHERE ccs.cabinet_id = :cabinetId"
            + " UNION "
            + "SELECT locker_charge_standard.id id,sys_dictionary.id boxSizeId,sys_dictionary.`code` CODE,sys_dictionary.`name` NAME,locker_charge_standard.price price,sys_dictionary.description description\n" +
                    "FROM locker_charge_standard RIGHT JOIN (SELECT DISTINCT locker_box.box_size_id FROM locker_box LEFT JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id\n" +
                    "WHERE locker_box.cabinet_id = :cabinetId AND locker_box.box_size_id NOT IN ( SELECT box_size_id FROM locker_cabinet_charge_standard WHERE cabinet_id = :cabinetId ) ) tab ON tab.box_size_id = locker_charge_standard.default_box_size LEFT JOIN sys_dictionary ON sys_dictionary.id = tab.box_size_id")
    Stream<Object[]> findBoxSize(@Param("cabinetId") int cabinetId);
}
