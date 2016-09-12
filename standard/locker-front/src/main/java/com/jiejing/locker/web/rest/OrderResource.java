package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Order;
import com.jiejing.locker.service.IOrderService;
import com.jiejing.locker.web.rest.view.HeaderUtil;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by lenovo on 2016/9/12.
 */
@RestController
@RequestMapping("api/order")
public class OrderResource {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(@RequestBody Order order) {
        order = orderService.create(order);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/order/" + order.getId()).build().toUri())
                .headers(HeaderUtil.createAlert("order.created", order.getId()))
                .body(new Response(order));
    }


    @RequestMapping(value = "/pay",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pay(@RequestBody Order order) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("http://jiejing/pay/url").build().toUri())
                .headers(HeaderUtil.createAlert("order.created", "http://jiejing/pay/url"))
                .body("{\"url\":\"http://jiejing/pay/url\",\"payType\":\"XJPAY\"}");
    }

    @RequestMapping(value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pay(@PathVariable("id") Integer id) {
        return orderService.findOne(id)
                .map(e -> new ResponseEntity<>(new Response<>(e), HttpStatus.OK))
                .orElse(new ResponseEntity<>(new Response(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()), HttpStatus.OK));
    }

}
