package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 资料信息扩展信息
 */
@Setter
@Getter
@Entity(name = "locker_lease_info_extra")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaseInfoExtra {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 资料证件
     */
    @Column(name = "lease_info_id", updatable = false)
    private Integer leaseInfoId;

    /**
     * 属性名称
     */
    @Column(name = "name", updatable = false)
    private String name;

    /**
     * 属性值
     */
    @Column(name = "value", updatable = false)
    private String value;


}