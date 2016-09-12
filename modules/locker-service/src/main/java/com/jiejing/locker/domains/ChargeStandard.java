package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.config.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * 收费标准
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "locker_charge_standard")
@EntityListeners(AuditingEntityListener.class)
public class ChargeStandard implements Serializable {

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

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    private BigDecimal price;//价格

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private Constants.ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @Column(name = "default_box_size", nullable = false)
    private Integer defaultBoxSize;
}
