package com.spring.feign.remote;

import com.spring.feign.common.ResponseMsg;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangmengc
 * @date 2018/11/26 14:14
 * @since v1.0.0
 */
@RequestMapping("/api")
public interface FeignDemo {

    @RequestMapping("/demo")
    ResponseMsg<String> hello();

}
