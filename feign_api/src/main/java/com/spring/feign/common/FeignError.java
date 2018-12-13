package com.spring.feign.common;

import lombok.Getter;

/**
 * @author zhangmengc
 * @date 2018/12/4 9:06
 * @since v1.0.0
 */
@Getter
public enum FeignError {

    /**
     * 连接读取超时
     */
    READ_TIME_OUT("READ_TIME_OUT", "连接读取超时"),

    /**
     * 连接超时
     */
    CONNECT_TIME_OUT("CONNECT_TIME_OUT", "连接超时"),

    /**
     * 连接被拒绝
     */
    CONNECTION_REFUSED("CONNECTION_REFUSED", "连接被拒绝"),

    /**
     * 触发Hystrix熔断
     */
    HYSTRIX_OPEN("HYSTRIX_OPEN", "触发Hystrix熔断"),

    /**
     * Hystrix执行超时
     */
    HYSTRIX_TIME_OUT("HYSTRIX_TIME_OUT", "Hystrix执行超时"),

    /**
     * 远程服务调用出错
     */
    REMOTE_SERVICE_EXCEPTION("REMOTE_SERVICE_EXCEPTION", "远程服务调用出错");

    private String errorCode;

    private String msg;

    FeignError(String errorCode, String msg){
        this.errorCode = errorCode;
        this.msg = msg;
    }

}
