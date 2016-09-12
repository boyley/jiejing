package com.jiejing.locker.web.rest;

import com.jiejing.locker.service.IChargeStandardService;
import com.jiejing.locker.service.dto.BoxSize;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2016/9/12.
 */
@RestController
@RequestMapping("api/boxSize")
public class BoxSizeResource {

    @Autowired
    private IChargeStandardService chargeStandardService;

    @RequestMapping(value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<BoxSize>> getBoxSize(@PathVariable("id") Integer id) {
        List<BoxSize> boxSizes = this.chargeStandardService.findBoxSize(id);
        return new Response<>(HttpStatus.OK.value(), boxSizes, HttpStatus.OK.getReasonPhrase());
    }
}
