package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.config.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Setter
@Getter
@Entity(name = "locker_keeplive")
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keeplive {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 类型,CABINET:柜子，BOX:箱子
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Constants.ObjectType type;

    /**
     * 柜子/箱子id
     */
    @Column(name = "object_id", nullable = false)
    private Integer objectId;

    /**
     * 检测时间
     */
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate;

    /**
     * 错误编码
     */
    @Column(name = "error_code", nullable = false)
    private String errorCode;

    /**
     * 描述
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * 轮询时间
     */
    @Column(name = "keeplive_time", nullable = false)
    private ZonedDateTime keepliveTime;

}