package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Setter
@Getter
@Entity(name = "locker_region")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class Region {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 编码
     */
    @Column(name = "code", nullable = false, length = 32)
    private String code;

    /**
     * 节点名称
     */
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    /**
     * 所属父节点id
     */
    @Column(name = "parent_id", nullable = true)
    private Integer parentId;

    /**
     * 访问路径
     */
    @Column(name = "url", nullable = true, length = 256)
    private String url;

    /**
     * 描述
     */
    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
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


}