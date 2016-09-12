package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * 字典
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "sys_dictionary")
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dictionary implements Serializable {

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
    @Column(name = "value_type", nullable = false, length = 32)
    private String valueType;//字典值类型
    @Column(name = "value", nullable = false)
    private String value;//字典值
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;//父节点id

    @Column(name = "parent_code", nullable = false, length = 32)
    private String parentCode;//parent_code
}
