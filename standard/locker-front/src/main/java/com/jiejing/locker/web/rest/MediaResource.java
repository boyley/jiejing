package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Media;
import com.jiejing.locker.service.IMediaService;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bogle on 2016/9/12.
 */
@RestController
@RequestMapping("api/media")
public class MediaResource {

    @Autowired
    private IMediaService mediaService;

    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pay() {
        List<Media> medias = mediaService.findAll();
        return new ResponseEntity<>(new Response<>(medias), HttpStatus.OK);
    }
}
