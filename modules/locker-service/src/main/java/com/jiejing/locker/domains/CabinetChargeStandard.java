package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 箱子收费标准中间表
 * Created by Bogle on 2016/9/12.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "locker_cabinet_charge_standard")
@EntityListeners(AuditingEntityListener.class)
public class CabinetChargeStandard implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    private Integer createdBy = 0;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    private Integer lastModifiedBy = 0;

    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    /**
     * 箱子规格
     */
    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;

    @Column(name = "charge_standard_id", nullable = false)
    private Integer chargeStandardId;
}
