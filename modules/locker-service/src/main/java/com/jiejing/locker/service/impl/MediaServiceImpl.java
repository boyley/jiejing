package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Media;
import com.jiejing.locker.repository.MediaRepository;
import com.jiejing.locker.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bogle on 2016/9/12.
 */
@Service
public class MediaServiceImpl implements IMediaService {

    @Autowired
    private MediaRepository mediaRepository;

    /**
     * 获取可用的广告
     * @return
     */
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}
