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
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * 订单
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "sys_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

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


    @Column(name = "order_num", nullable = false, length = 32)
    private String orderNum;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state", nullable = true)
    private Constants.OrderState orderState;//订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭

    @Column(name = "order_source", nullable = false)
    private Integer orderSource;//下单渠道

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    private BigDecimal price;//费用

    @Column(name = "pay_type", nullable = true)
    private Integer payType;//支付方式,关联sys_dictionary表

    /**
     * 创建方式
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "create_type", nullable = true)
    private Constants.CreateType createType;

    //    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "order_id")
    @Transient
    private LeaseBox leaseBox;
}
