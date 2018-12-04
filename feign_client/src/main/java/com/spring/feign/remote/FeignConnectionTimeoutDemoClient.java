package com.spring.feign.remote;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author zhangmengc
 * @date 2018/11/26 10:52
 * @since v1.0.0
 */
@FeignClient(name = "feign-service-connect", path = "/search", url = "https://www.google.com", fallbackFactory = FeignConnectionTimeoutFallbackFactory.class)
public interface FeignConnectionTimeoutDemoClient extends FeignConnectionTimeoutDemo {
}
