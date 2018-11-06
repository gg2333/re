package com.example.re.ctrl;

import com.example.re.resp.BaseResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/test")
public class TestCtrl {

    @GetMapping(path = "/get")
    public Mono<BaseResp<String>> test() {
        return Mono.just(BaseResp.success());
    }

}
