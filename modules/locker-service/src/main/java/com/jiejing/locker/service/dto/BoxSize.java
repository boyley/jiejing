package com.jiejing.locker.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2016/9/9.
 */
@Data
public class BoxSize implements Serializable {

    private Integer id;//收费标准id
    private Integer boxSizeId;//收费规格id
    private String code; // 规格编码
    private String name;// 规格名称
    private BigDecimal price;//价格
    private String description;//描述
    private boolean enable;//是否有可用的箱子

}
