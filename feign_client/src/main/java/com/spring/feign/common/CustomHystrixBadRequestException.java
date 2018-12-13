
package com.spring.feign.common;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义Hystrix异常 禁止进入fallback
 * @author zhangmengc
 * @date 2018/12/3 17:06
 * @since v1.0.0
 */
@Getter
@ToString
public class CustomHystrixBadRequestException extends HystrixBadRequestException {

    /**
     * 错误编码
     */
    private String errCode;

    /**
     * 错误code
     */
    private String errMsg;

    /**
     * 参数
     */
    private Object obj;

    /**
     * 带错误编码、异常信息生成异常
     * @param errCode
     * @param errMsg
     */
    private CustomHystrixBadRequestException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * 带错误编码、异常信息、消息参数生成异常
     * @param errCode
     * @param errMsg
     * @param obj
     */
    private CustomHystrixBadRequestException(String errCode, String errMsg, Object obj) {
        this(errCode, errMsg);
        this.obj = obj;
    }

    /**
     * 带错误编码、异常信息生成异常
     * @param errCode
     * @param errMsg
     * @return
     */
    public static CustomHystrixBadRequestException buildFailException(String errCode, String errMsg) {
        return new CustomHystrixBadRequestException(errCode, errMsg);
    }

    /**
     * 带错误编码、异常信息、消息参数生成异常
     * @param errCode
     * @param errMsg
     * @param obj
     * @return
     */
    public static CustomHystrixBadRequestException buildFailException(String errCode, String errMsg, Object obj) {
        return new CustomHystrixBadRequestException(errCode, errMsg, obj);
    }

}
