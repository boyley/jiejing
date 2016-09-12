package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Bogle on 2016/9/12.
 */
public interface MediaRepository extends JpaRepository<Media, Integer>, JpaSpecificationExecutor<Media> {

}
