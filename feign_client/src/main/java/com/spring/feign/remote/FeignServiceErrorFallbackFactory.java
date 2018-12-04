
package com.spring.feign.remote;

import com.spring.feign.common.FeignError;
import com.spring.feign.common.ResponseMsg;
import feign.RetryableException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.net.SocketTimeoutException;

/**
 * @author zhangmengc
 * @date 2018/12/3 9:08
 * @since v1.0.0
 */
@Slf4j
@Component
public class FeignServiceErrorFallbackFactory implements FallbackFactory<FeignServiceErrorDemoClient> {

    @Autowired
    private FeignGetErrorMsg feignGetErrorMsg;

    @Override
    public FeignServiceErrorDemoClient create(Throwable cause) {
        FeignError feignError = feignGetErrorMsg.getFeignError(cause);
        return new FeignServiceErrorDemoClient() {
            @Override
            public ResponseMsg<String> testCatchException(String test) {
                log.error("{}, test:{}", feignError.getMsg(), test, cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }

            @Override
            public ResponseMsg<String> testCatchCustomException(String test) {
                log.error("{}, test:{}", feignError.getMsg(), test, cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }

            @Override
            public ResponseMsg<String> testThrowException(String test) {
                log.error("{}, test:{}", feignError.getMsg(), test, cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }

            @Override
            public ResponseMsg<String> testThrowCustomException(String test) {
                log.error("{}, test:{}", feignError.getMsg(), test, cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }
        };
    }

}
