package com.jiejing.locker.web.rest.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/9/12.
 */
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {

    public Response(T data) {
        this(200, data, "OK");
    }

    public Response(int code, String message) {
        this(code, null, message);
    }

    private int code;
    private T data;
    private String message;
}
