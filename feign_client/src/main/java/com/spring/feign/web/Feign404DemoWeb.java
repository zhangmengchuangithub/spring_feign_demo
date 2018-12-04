
package com.spring.feign.web;

import com.spring.feign.common.ResponseMsg;
import com.spring.feign.remote.Feign404DemoClient;
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
public class Feign404DemoWeb {

    @Autowired
    private Feign404DemoClient feign404DemoClient;

    @RequestMapping("/feign404")
    @ResponseBody
    public ResponseMsg<String> fiegn404 () {
        ResponseMsg<String> res = feign404DemoClient.fiegn404();
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

}
