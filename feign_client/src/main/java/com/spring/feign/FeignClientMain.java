
package com.spring.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author zhangmengc
 * @date 2018/11/26 11:02
 * @since v1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class FeignClientMain {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientMain.class, args);
        System.out.println("feign client web started");
    }

}
