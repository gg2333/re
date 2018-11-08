package com.example.re.resp;

public class BaseResp<T> {

    public int code;

    public String message;

    public T data;

    public BaseResp() {
        this.code = 0;
        this.message = "ok";
    }

    public BaseResp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResp(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResp<T> success() {
        return new BaseResp<>();
    }

    public static <T> BaseResp<T> success(int code, String msg) {
        return new BaseResp<>(code, msg);
    }

    public static <T> BaseResp<T> error() {
        return new BaseResp<>(-1, "error");
    }

    public static <T> BaseResp<T> error(int code, String msg) {
        return new BaseResp<>(code, msg);
    }

    public static <T> BaseResp<T> create(T data) {
        return new BaseResp<>(0, "ok", data);
    }

}
