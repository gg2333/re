package com.example.re.rx;

public class MapperException extends Exception {

    private int code;
    private String message;

    public MapperException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
