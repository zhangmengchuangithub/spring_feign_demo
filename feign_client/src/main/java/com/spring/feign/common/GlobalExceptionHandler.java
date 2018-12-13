
package com.spring.feign.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangmengc
 * @date 2018/11/26 16:51
 * @since v1.0.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomHystrixBadRequestException.class)
    @ResponseBody
    public ResponseMsg HystrixBadRequestExceptionhandler(CustomHystrixBadRequestException e, HttpServletRequest req) {
        log.error("hystrix bad request exception", e);
            return new ResponseMsg.Builder<String>(false)
                    .errorCode(e.getErrCode())
                    .message(e.getErrMsg())
                    .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseMsg handler(Exception e, HttpServletRequest req) {
        log.error("global catch exception", e);
        return new ResponseMsg.Builder<String>(false)
                .errorCode("Internal Server Error")
                .message("Internal Server Error")
                .build();
    }

}
