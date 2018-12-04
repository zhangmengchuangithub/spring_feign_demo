
package com.spring.feign.web;

import com.spring.feign.common.ResponseMsg;
import com.spring.feign.remote.FeignReadTimeoutDemo;
import com.spring.feign.remote.FeignReadTimeoutDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangmengc
 * @date 2018/11/26 11:22
 * @since v1.0.0
 */
@Controller
@RequestMapping("/test")
public class FeignReadTimeoutDemoWeb {

    @Autowired
    private FeignReadTimeoutDemoClient feignReadTimeoutDemoClient;

    @RequestMapping("/readtimeout")
    @ResponseBody
    public ResponseMsg<String> readTimeout () {
        ResponseMsg<String> res = feignReadTimeoutDemoClient.readTimeout();
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

}
