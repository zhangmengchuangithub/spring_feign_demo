package com.spring.feign.remote;

import com.spring.feign.common.ResponseMsg;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangmengc
 * @date 2018/11/26 13:48
 * @since v1.0.0
 */
@RequestMapping("/api")
public interface FeignServiceErrorDemo {

    /**
     * 测试返回捕获的异常的封装对象
     * @return
     * @param test
     */
    @RequestMapping("/exception")
    ResponseMsg<String> testCatchException(String test);

    /**
     * 测试返回捕获的自定义异常封装对象
     * @return
     * @param test
     */
    @RequestMapping("/customexception")
    ResponseMsg<String> testCatchCustomException(String test);

    /**
     * 测试返回未捕获异常
     * @return
     * @param test
     */
    @RequestMapping("/throwexception")
    ResponseMsg<String> testThrowException(String test);

    /**
     * 测试返回未捕获自定义异常
     * @return
     * @param test
     */
    @RequestMapping("/throwcustomexception")
    ResponseMsg<String> testThrowCustomException(String test);

}
