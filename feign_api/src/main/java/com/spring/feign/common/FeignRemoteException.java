
package com.spring.feign.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @author zhangmengc
 * @date 2018/11/26 17:10
 * @since v1.0.0
 */
@Getter
@ToString
public class FeignRemoteException extends RuntimeException {

    private String message;

    private FeignRemoteException(String message) {
        super(message);
        this.message = message;
    }

    public static FeignRemoteException buildFailException(String message) {
        return new FeignRemoteException(message);
    }

}
