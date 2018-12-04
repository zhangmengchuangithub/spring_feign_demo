
package com.spring.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangmengc
 * @date 2018/11/26 11:02
 * @since v1.0.0
 */
@SpringBootApplication
public class FeignServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceMain.class, args);
        System.out.println("feign server web started");
    }

}
