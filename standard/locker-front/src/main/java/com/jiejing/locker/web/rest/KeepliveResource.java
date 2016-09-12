package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Keeplive;
import com.jiejing.locker.exception.BadException;
import com.jiejing.locker.service.IKeepliveService;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bogle on 2016/9/12.
 */
@RestController
@RequestMapping("api/keeplive")
public class KeepliveResource {

    @Autowired
    private IKeepliveService keepliveService;

    @RequestMapping(value = "/feedback",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> keeplive(@RequestBody List<Keeplive> keeplives) {
        List<Keeplive> results = keepliveService.save(keeplives);
        keeplives.forEach(e -> {
            if (e.getObjectId() == null) throw new BadException("objectId 必传");
            if (e.getType() == null) throw new BadException("type 必传");
            if (StringUtils.isEmpty(e.getErrorCode())) throw new BadException("errorCode 必传");
            if (StringUtils.isEmpty(e.getDescription())) throw new BadException("description 必传");
            if (e.getKeepliveTime() == null) throw new BadException("keepliveTime 必传");
        });
        Map result = new HashMap<>();
        result.put("code", results.size());
        return new ResponseEntity<>(new Response<>(result), HttpStatus.OK);
    }
}
