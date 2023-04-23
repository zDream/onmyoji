package com.onmyoji;

import lombok.Data;

/**
 * @author zhutongtong
 * @date 2023/4/23 17:03
 */
@Data
public class Response {

    Integer code;

    String message;
    Integer duration;
    String version;
    Result result;
}
