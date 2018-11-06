package com.example.re.resp;

public class ListResp<T> {

    public int size;
    public int number;
    public int numberOfElements;
    public int totalPages;
    public long totalElements;
    public boolean isLast;

    public T data;

    public ListResp(T data) {
        this.data = data;
    }

    public static <T> ListResp<T> create(T data) {
        return new ListResp<>(data);
    }

}
