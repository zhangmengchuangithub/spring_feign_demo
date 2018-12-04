
package com.spring.feign.remote;

import com.spring.feign.common.ResponseMsg;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangmengc
 * @date 2018/11/26 10:49
 * @since v1.0.0
 */
@RestController
public class FeignDemoService implements FeignDemo {

    @Override
    public ResponseMsg<String> hello() {
        return new ResponseMsg.Builder<String>(true).data("hello feign demo").build();
    }
}
