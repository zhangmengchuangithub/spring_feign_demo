
package com.spring.feign.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author zhangmengc
 * @date 2018/11/23 10:55
 * @since v1.0.0
 */
@Getter
@Setter
@ToString
public class ResponseMsg<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;

    private String errorCode;

    private String message;

    private boolean success;

    public static class Builder<T> {

        private T data;

        private String errorCode;

        private String message;

        private final boolean success;

        public Builder(boolean success) {
            this.success = success;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseMsg build() {
            if (!success) {
                if (StringUtils.isBlank(errorCode)) {
                    throw new IllegalArgumentException("errorCode cannot be null when success is an error");
                }
                if (StringUtils.isBlank(message)) {
                    throw new IllegalArgumentException("message cannot be null when success is an error");
                }
            }
            return new ResponseMsg(this);
        }

    }

    public ResponseMsg(){
    }

    private ResponseMsg(Builder<T> builder) {
        this.data = builder.data;
        this.errorCode = builder.errorCode;
        this.message = builder.message;
        this.success = builder.success;
    }

}
