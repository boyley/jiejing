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
import java.time.ZonedDateTime;

@Setter
@Getter
@Entity(name = "locker_media")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Media {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title", nullable = false, length = 120)
    private String title;

    /**
     * 内容
     */
    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    /**
     * 跳转目标
     */
    @Column(name = "target_url", nullable = false, length = 256)
    private String targetUrl;

    /**
     * 广告链接
     */
    @Column(name = "url", nullable = false, length = 256)
    private String url;

    /**
     * 停留时间(单位秒)
     */
    @Column(name = "time", nullable = true)
    private Integer time;

    /**
     * 排序(越大越前)
     */
    @Column(name = "seq", nullable = true)
    private Integer seq;

    /**
     * 开始时间
     */
    @Column(name = "start_time", nullable = false)
    private ZonedDateTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time", nullable = false)
    private ZonedDateTime endTime;

    /**
     * 文件类型
     */
    @Column(name = "media", nullable = false, length = 32)
    private String media;

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

    /**
     * 是否可用
     */
    @Column(name = "enable", nullable = true)
    private Boolean enable;
}