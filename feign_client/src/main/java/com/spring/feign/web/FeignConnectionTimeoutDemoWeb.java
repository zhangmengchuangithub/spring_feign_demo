
package com.spring.feign.web;

import com.spring.feign.common.ResponseMsg;
import com.spring.feign.remote.FeignConnectionTimeoutDemoClient;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FeignConnectionTimeoutDemoWeb {

    @Autowired
    private FeignConnectionTimeoutDemoClient feignConnectionTimeoutDemoClient;

    @RequestMapping("/connectiontimeout")
    @ResponseBody
    public ResponseMsg<String> connectionTimeout () {
        log.info("connect time out test beign.....");
        ResponseMsg<String> res = feignConnectionTimeoutDemoClient.connectionTimeout();
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

}
