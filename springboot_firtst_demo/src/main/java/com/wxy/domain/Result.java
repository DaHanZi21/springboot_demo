package com.wxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//1 说明成功 0说明失败
    private String msg;//响应的信息
    private Object data;//返回的Json数据或一些其他的数据

    public static Result success() {
        return new Result(1, "success", null);
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }
}
