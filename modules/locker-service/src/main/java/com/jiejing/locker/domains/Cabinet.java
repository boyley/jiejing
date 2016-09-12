package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiejing.locker.config.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 柜子信息表
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "locker_cabinet")
@EntityListeners(AuditingEntityListener.class)
public class Cabinet implements Serializable {

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

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @Column(name = "code", nullable = false, length = 32)
    private String code;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "region_id", nullable = false)
    private Integer regionId;//地址：道路/小区 编码
    @Column(name = "lon", nullable = true, precision = 10, scale = 5)
    private BigDecimal lon;//地理经度
    @Column(name = "lat", nullable = true, precision = 10, scale = 2)
    private BigDecimal lat;//地理纬度
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Constants.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    @Column(name = "multiple", nullable = false)
    private Boolean multiple = false;//可多次使用
    @Column(name = "voucher_verify", nullable = false)
    private Boolean voucherVerify = false;//是否证件验证
    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @Column(name = "open_time", nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime openTime = LocalTime.now();//开机时间

    @Column(name = "close_time", nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime closeTime = LocalTime.now();//关机时间

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cabinet_id", referencedColumnName = "id")
//    @Transient
    private Set<Box> boxs;
}
