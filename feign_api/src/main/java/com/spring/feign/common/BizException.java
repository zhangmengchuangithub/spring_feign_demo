
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
public class BizException extends RuntimeException {

    private String message;

    public BizException(){}

    public BizException(String message) {
        super(message);
        this.message = message;
    }

}
