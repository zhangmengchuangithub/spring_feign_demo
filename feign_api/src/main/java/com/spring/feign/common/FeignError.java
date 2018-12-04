package com.spring.feign.common;

import lombok.Getter;

/**
 * @author zhangmengc
 * @date 2018/12/4 9:06
 * @since v1.0.0
 */
@Getter
public enum FeignError {

    READ_TIME_OUT("READ_TIME_OUT", "读超时"),

    CONNECT_TIME_OUT("CONNECT_TIME_OUT", "连接超时"),

    HYSTRIX_OPEN("HYSTRIX_OPEN", "Hystrix熔断开启"),

    HYSTRIX_TIME_OUT("HYSTRIX_TIME_OUT", "Hystrix执行超时"),

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "服务器内部错误");

    private String errorCode;

    private String msg;

    FeignError(String errorCode, String msg){
        this.errorCode = errorCode;
        this.msg = msg;
    }

}
