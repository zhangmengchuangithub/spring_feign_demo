
package com.spring.feign.common;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangmengc
 * @date 2018/12/3 17:06
 * @since v1.0.0
 */
@Getter
@Setter
@ToString
public class CustomHystrixBadRequestException extends HystrixBadRequestException {

    private String errorCode;

    private String message;

    private boolean success;

    private CustomHystrixBadRequestException(boolean success, String errorCode, String message) {
        super(message);
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
    }

    public static CustomHystrixBadRequestException buildFailException(boolean success, String errorCode, String message) {
        return new CustomHystrixBadRequestException(success, errorCode, message);
    }

}
