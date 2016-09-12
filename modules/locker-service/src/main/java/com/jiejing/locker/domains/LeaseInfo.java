package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 订单
 * Created by Bogle on 2016/9/12.
 */
@Setter
@Getter
@Entity(name = "locker_lease_info")
@JsonIgnoreProperties(value = {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaseInfo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "info_type", nullable = false)
    private Integer infoType;//资料类型（引用sys_dictionary）,存取动作

    @Column(name = "code", nullable = false, length = 32)
    private String code;

    @Column(name = "name", nullable = true, length = 30)
    private String name;//资料名称

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "info_file", nullable = true, length = 1000)
    private String infoile;//资料文件

    /**
     * 资料信息
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lease_info_id")
    private List<LeaseInfoExtra> leaseInfoExtras;
}
