
package com.spring.feign.remote;

import com.spring.feign.common.FeignError;
import com.spring.feign.common.ResponseMsg;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangmengc
 * @date 2018/12/3 9:08
 * @since v1.0.0
 */
@Slf4j
@Component
public class FeignFallbackFactory implements FallbackFactory<FeignDemoClient> {

    @Autowired
    private FeignGetErrorMsg feignGetErrorMsg;

    @Override
    public FeignDemoClient create(Throwable cause) {
        FeignError feignError = feignGetErrorMsg.getFeignError(cause);
        return new FeignDemoClient() {
            @Override
            public ResponseMsg<String> hello() {
                log.error("{}", feignError.getMsg(), cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }
        };
    }

}
