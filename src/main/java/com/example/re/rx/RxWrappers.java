package com.example.re.rx;

import com.example.re.resp.BaseResp;
import com.example.re.resp.ListResp;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class RxWrappers {

    public static <T> Function<T, Mono<? extends BaseResp<T>>> baseWrapper() {
        return new Function<T, Mono<? extends BaseResp<T>>>() {
            @Override
            public Mono<? extends BaseResp<T>> apply(T t) {
                return Mono.just(BaseResp.create(t));
            }
        };
    }

    public static <T> Function<T, Mono<? extends ListResp<T>>> listWrapper() {
        return new Function<T, Mono<? extends ListResp<T>>>() {
            @Override
            public Mono<? extends ListResp<T>> apply(T t) {
                return Mono.just(ListResp.create(t));
            }
        };
    }

//    public static <T> Function<Page<T>, Mono<? extends DR<List<T>>>> pageWrapper() {
//        return new Function<Page<T>, Mono<? extends DR<List<T>>>>() {
//            @Override
//            public Mono<? extends DR<List<T>>> apply(Page<T> ts) {
//                DR<List<T>> listDR = DR.create(ts.getContent());
//                listDR.number = ts.getNumber();
//                listDR.numberOfElements = ts.getNumberOfElements();
//                listDR.size = ts.getSize();
//                listDR.isLast = ts.isLast();
//                listDR.totalPages = ts.getTotalPages();
//                listDR.totalElements = ts.getTotalElements();
//                return Mono.just(listDR);
//            }
//        };
//    }

}
