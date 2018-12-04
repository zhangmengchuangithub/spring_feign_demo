
package com.spring.feign.remote;

import com.spring.feign.common.ResponseMsg;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangmengc
 * @date 2018/11/26 10:49
 * @since v1.0.0
 */
@RestController
public class FeignReadTimeoutDemoService implements FeignReadTimeoutDemo {

    @Override
    public ResponseMsg<String> readTimeout() {
        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
