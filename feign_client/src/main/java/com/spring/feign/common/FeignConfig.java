
package com.spring.feign.common;

import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author zhangmengc
 * @date 2018/11/27 8:53
 * @since v1.0.0
 */
@Slf4j
@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String methodKey, Response response) {
                try {
                    if (response.body() != null) {
                        String body = Util.toString(response.body().asReader());
                        JSONObject jsonObject = JSONObject.parseObject(body);
                        log.error("后端报错:{}", jsonObject);
                        // 判断服务器未补获的异常
                        Integer status = jsonObject.getInteger("status");

                        // 判断自定义异常 兼容以前版本（后续新代码不建议server端直接抛异常给前端）
                        Boolean success = jsonObject.getBoolean("success");
                        if (status != null) {
                            if (status == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                                // 封装成CustomHystrixBadRequestException不进入fallback
                                return CustomHystrixBadRequestException
                                        .buildFailException(false, status.toString(), jsonObject.getString("error"));
                            } else {
                                return FeignRemoteException.buildFailException(body);
                            }
                        } else if(success != null && !success) {
                            ResponseMsg msg = JSONObject.parseObject(body, ResponseMsg.class);
                            return CustomHystrixBadRequestException
                                    .buildFailException(msg.isSuccess(), msg.getErrorCode(), msg.getMessage());
                        }
                    }
                } catch (Exception e) {
                    log.error("处理Feign的异常信息失败！", e);
                }
                // 处理其他异常情况
                return FeignRemoteException.buildFailException("远程服务调用失败！");
            }
        };
    }

}
