package com.example.re.resp;

public class PageResp<T> {

    public int size;
    public int number;
    public int numberOfElements;
    public int totalPages;
    public long totalElements;
    public boolean isLast;

    public T data;

    public PageResp(T data) {
        this.data = data;
    }

    public static <T> PageResp<T> create(T data) {
        return new PageResp<>(data);
    }

}
