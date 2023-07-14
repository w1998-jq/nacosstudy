package com.nacos.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String info;
    private T data;

    public CommonResult(Integer code, String info) {
        this(code,info,null);
    }
}
