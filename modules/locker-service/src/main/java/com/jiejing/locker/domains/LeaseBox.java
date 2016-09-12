package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.config.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * 租箱记录
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "locker_lease_box")
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "price", "orderId", "boxState"})
public class LeaseBox implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private Integer createdBy = 0;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Integer lastModifiedBy = 0;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    @Column(name = "box_id", nullable = false)
    private Integer boxId;

    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;

    @Column(name = "charge_standard_id", nullable = false)
    private Integer chargeStandardId;

    @Column(name = "cabinet_name", nullable = false, length = 32)
    private String cabinetName;

    @Column(name = "cabinet_code", nullable = false, length = 32)
    private String cabinetCode;

    @Column(name = "box_name", nullable = false, length = 32)
    private String boxName;

    @Column(name = "box_code", nullable = false, length = 32)
    private String boxCode;

    @Column(name = "box_size_name", nullable = false, length = 32)
    private String boxSizeName;

    @Column(name = "box_size_code", nullable = false, length = 32)
    private String boxSizeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private Constants.ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    private BigDecimal price;//价格

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "box_state", nullable = false)
    private Constants.BoxState boxState;//箱状态DQ:待取，YQ：已取

    @Column(name = "check_type", nullable = false)
    private Integer checkType;//校验模式（引用sys_dictionary）

    @Transient
    private String checkCode;//取件方式

    @Column(name = "timeout", nullable = true)
    private Integer timeout;//是否超时寄存,大于0表示超时，具体数值表示超时值


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "locker_lease_redeem_info",
            joinColumns = { @JoinColumn(name = "lease_box_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "lease_info_id", referencedColumnName = "id") })
    private List<LeaseInfo> leaseInfos;//存储资料
}
