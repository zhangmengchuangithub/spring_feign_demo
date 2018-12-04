
package com.spring.feign.web;

import com.spring.feign.common.ResponseMsg;
import com.spring.feign.remote.FeignDemoClient;
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
public class FeignDemoWeb {

    @Autowired
    private FeignDemoClient feignDemoClient;

    @RequestMapping("/demo")
    @ResponseBody
    public ResponseMsg<String> test () {
        ResponseMsg<String> res = feignDemoClient.hello();
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

}
