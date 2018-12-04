
package com.spring.feign.common;

/**
 * @author zhangmengc
 * @date 2018/11/26 17:10
 * @since v1.0.0
 */
public class SystemException extends RuntimeException {

    private String errorCode;

    private String message;

    private boolean success;

    private SystemException(boolean success, String errorCode, String message) {
        super(message);
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
    }

    public static SystemException buildFailException(boolean success, String errorCode, String message) {
        return new SystemException(success, errorCode, message);
    }

}
