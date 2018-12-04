
package com.spring.feign.remote;

import com.spring.feign.common.BizException;
import com.spring.feign.common.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangmengc
 * @date 2018/11/26 10:49
 * @since v1.0.0
 */
@RestController
public class FeignServiceErrorDemoService implements FeignServiceErrorDemo {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Override
    public ResponseMsg<String> testCatchException(String test) {
        return new ResponseMsg.Builder<String>(false).errorCode("").message("").build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Override
    public ResponseMsg<String> testCatchCustomException(String test) {
        return new ResponseMsg.Builder<String>(false).errorCode("").message("").build();
    }

    @Override
    public ResponseMsg<String> testThrowException(String test) {
        throw new IllegalArgumentException();
    }

    @Override
    public ResponseMsg<String> testThrowCustomException(String test) {
        throw new BizException("test custom exception");
    }
}
