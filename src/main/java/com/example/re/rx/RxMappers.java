package com.example.re.rx;

import com.example.re.resp.BaseResp;
import com.example.re.resp.ListResp;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class RxMappers {

    public static Function<BaseResp, Mono<BaseResp>> selfMapper() {
        return new Function<BaseResp, Mono<BaseResp>>() {
            @Override
            public Mono<BaseResp> apply(BaseResp baseResp) {
                if (baseResp.code != 0) {
                    return Mono.error(new MapperException(baseResp.code, baseResp.message));
                }
                return Mono.just(baseResp);
            }
        };
    }

    public static <T> Function<BaseResp<T>, Mono<T>> baseMapper() {
        return new Function<BaseResp<T>, Mono<T>>() {
            @Override
            public Mono<T> apply(BaseResp<T> tBaseResp) {
                if (tBaseResp.code != 0) {
                    return Mono.error(new MapperException(tBaseResp.code, tBaseResp.message));
                }
                return Mono.just(tBaseResp.data);
            }
        };
    }

    public static <T> Function<ListResp<T>, Mono<T>> listMapper() {
        return new Function<ListResp<T>, Mono<T>>() {
            @Override
            public Mono<T> apply(ListResp<T> tListResp) {
                if (tListResp.data == null) {
                    return Mono.error(new EmptyException());
                }
                return Mono.just(tListResp.data);
            }
        };
    }


}
