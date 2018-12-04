
package com.spring.feign.web;

import com.spring.feign.common.ResponseMsg;
import com.spring.feign.remote.FeignServiceErrorDemoClient;
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
public class FeignServiceErrorDemoWeb {

    @Autowired
    private FeignServiceErrorDemoClient feignServiceErrorDemoClient;

    @RequestMapping("/exception")
    @ResponseBody
    public ResponseMsg<String> testCatchException(String test){
        ResponseMsg<String> res = feignServiceErrorDemoClient.testCatchException(test);
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

    @RequestMapping("/customexception")
    @ResponseBody
    public ResponseMsg<String> testCatchCustomException(String test){
        ResponseMsg<String> res = feignServiceErrorDemoClient.testCatchCustomException(test);
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

    @RequestMapping("/throwexception")
    @ResponseBody
    public ResponseMsg<String> testThrowException(String test){
        ResponseMsg<String> res = feignServiceErrorDemoClient.testThrowException(test);
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

    @RequestMapping("/throwcustomexception")
    @ResponseBody
    public ResponseMsg<String> testThrowCustomException(String test){
        ResponseMsg<String> res = feignServiceErrorDemoClient.testThrowCustomException(test);
        if (res.isSuccess()) {
            return res;
        }
        // 执行别的业务
        return res;
    }

}
