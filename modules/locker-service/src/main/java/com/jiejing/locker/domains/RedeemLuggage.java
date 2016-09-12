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

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * 取箱记录
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "locker_lease_info")
@JsonIgnoreProperties(value = {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedeemLuggage implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "lease_box_id", nullable = false)
    private Integer leaseBoxId;//存箱记录id

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

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

    @Column(name = "timeout", nullable = true)
    private Integer timeout;//是否超时寄存,大于0表示超时，具体数值表示超时值

    @Column(name = "retreat_id", nullable = true)
    private Integer retreatId;//补单id

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "result", nullable = false)
    private Constants.Result result;//结果

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "locker_lease_redeem_info",
            joinColumns = { @JoinColumn(name = "redeem_luggage_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "lease_info_id", referencedColumnName = "id") })
    private List<LeaseInfo> leaseInfos;//存储资料
}
