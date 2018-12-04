
package com.spring.feign.remote;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.spring.feign.common.FeignError;
import feign.RetryableException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author zhangmengc
 * @date 2018/12/4 9:05
 * @since v1.0.0
 */
@Component
public class FeignGetErrorMsg {

    public static final String HYSTRIX_CIRCUIT_SHORT_CIRCUITED_AND_IS_OPEN = "Hystrix circuit short-circuited and is OPEN";
    public static final String READ_TIMED_OUT = "Read timed out";
    public static final String CONNECT_TIMED_OUT = "connect timed out";

    /**
     * 根据错误封装异常
     * 使用者可自行修改
     * @param cause
     * @return
     */
    protected FeignError getFeignError(Throwable cause) {
        String msg = cause.getMessage();
        if (cause instanceof RetryableException && StringUtils.isNotBlank(msg)) {
            if (msg.startsWith(READ_TIMED_OUT)) {
                return FeignError.READ_TIME_OUT;
            } else if (msg.startsWith(CONNECT_TIMED_OUT)) {
                return FeignError.CONNECT_TIME_OUT;
            }
        } else if (cause instanceof HystrixTimeoutException) {
            return FeignError.HYSTRIX_TIME_OUT;
        } else if (cause instanceof RuntimeException) {
            if (HYSTRIX_CIRCUIT_SHORT_CIRCUITED_AND_IS_OPEN.equals(msg)) {
                return FeignError.HYSTRIX_OPEN;
            }
        }
        return FeignError.INTERNAL_SERVER_ERROR;
    }

}
