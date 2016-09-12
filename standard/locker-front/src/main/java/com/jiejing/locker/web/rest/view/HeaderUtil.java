package com.jiejing.locker.web.rest.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * Utility class for HTTP headers creation.
 */
public class HeaderUtil {

    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    /**
     * 原生构造方法
     * @param message
     * @param param
     * @return
     */
    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-jiejing-alert", message);
        headers.add("X-jiejing-params", param);
        return headers;
    }

    public static HttpHeaders createAlert(String message, Integer param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-jiejing-alert", message);
        headers.add("X-jiejing-params", param.toString());
        return headers;
    }

    /**
     * 创建
     * @param entityName
     * @param param
     * @return
     */
    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return createAlert("jiejing." + entityName + ".created", param);
    }

    /**
     * 更新
     * @param entityName
     * @param param
     * @return
     */
    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert("jiejing." + entityName + ".updated", param);
    }

    /**
     * 删除
     * @param entityName
     * @param param
     * @return
     */
    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert("jiejing." + entityName + ".deleted", param);
    }

    /**
     * 异常信息
     * @param entityName
     * @param errorKey
     * @param defaultMessage
     * @return
     */
    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        log.error("Entity creation failed, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-jiejing-error", "error." + errorKey);
        headers.add("X-jiejing-params", entityName);
        return headers;
    }
}
