package com.onmyoji;

import lombok.Data;

import java.util.List;

/**
 * @author zhutongtong
 * @date 2023/4/23 17:06
 */
@Data
public class Result {
    Integer angle;
    Integer width;
    Integer height;
    List<Lines> lines;
}
