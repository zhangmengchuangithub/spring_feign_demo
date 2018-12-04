
package com.spring.feign.remote;

import com.spring.feign.common.FeignError;
import com.spring.feign.common.ResponseMsg;
import feign.RetryableException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;

/**
 * @author zhangmengc
 * @date 2018/12/3 9:08
 * @since v1.0.0
 */
@Slf4j
@Component
public class FeignReadTimeoutFallbackFactory implements FallbackFactory<FeignReadTimeoutDemoClient> {

    @Autowired
    private FeignGetErrorMsg feignGetErrorMsg;

    @Override
    public FeignReadTimeoutDemoClient create(Throwable cause) {
        FeignError feignError = feignGetErrorMsg.getFeignError(cause);
        return new FeignReadTimeoutDemoClient() {
            @Override
            public ResponseMsg<String> readTimeout() {
                log.error("{}", feignError.getMsg(), cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }
        };
    }

}
