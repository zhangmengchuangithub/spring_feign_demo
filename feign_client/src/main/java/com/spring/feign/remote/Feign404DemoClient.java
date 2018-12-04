package com.spring.feign.remote;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author zhangmengc
 * @date 2018/11/26 10:52
 * @since v1.0.0
 */
@FeignClient(name = "feign-service", path = "/service", fallbackFactory = Feign404FallbackFactory.class)
public interface Feign404DemoClient extends Feign404Demo {
}
