
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
public class Feign404FallbackFactory implements FallbackFactory<Feign404DemoClient> {

    @Autowired
    private FeignGetErrorMsg feignGetErrorMsg;

    @Override
    public Feign404DemoClient create(Throwable cause) {
        FeignError feignError = feignGetErrorMsg.getFeignError(cause);
        return new Feign404DemoClient() {
            @Override
            public ResponseMsg<String> fiegn404() {
                log.error("{}", feignError.getMsg(), cause);
                return new ResponseMsg.Builder<String>(false)
                        .errorCode(feignError.getErrorCode())
                        .message(feignError.getMsg())
                        .build();
            }
        };
    }

}
