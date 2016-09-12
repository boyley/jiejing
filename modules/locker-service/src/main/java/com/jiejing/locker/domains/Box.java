package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.time.ZonedDateTime;

/**
 * 箱子信息
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "locker_box")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Box implements Serializable {

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

    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "code", nullable = false, length = 32)
    private String code;
    //    @Column(name = "cabinet_id", nullable = false)
//    private Integer cabinetId;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "cabinet_id")
    private Cabinet cabinet;

    //    @Column(name = "box_size_id", nullable = false)
//    private Integer boxSizeId;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "box_size_id",referencedColumnName = "id")
    private Dictionary boxSize;

    @Transient
    private String boxSizeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "gate_lock_state", nullable = true)
    private Constants.GateLockState gateLockState;

    @Enumerated(EnumType.STRING)
    @Column(name = "deposit_state", nullable = true)
    private Constants.DepositState depositState;//存物状态Y:有存物，N：无存物，ERROR：异常

    @Enumerated(EnumType.STRING)
    @Column(name = "box_state", nullable = false)
    private Constants.BoxState boxState;

    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Constants.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id
}
