package cn.jiyun.result;

import lombok.Data;

import java.io.Serializable;

@Data

public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        Result result = new Result();
        result.setCode(200);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result result = new Result();
        result.setCode(300);
        result.setMsg(message);
        return result;
    }

}
