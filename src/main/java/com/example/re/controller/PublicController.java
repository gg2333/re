package com.example.re.controller;

import com.example.re.resp.BaseResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/public")
public class PublicController {

    @GetMapping(path = "/get")
    public Mono<BaseResp> get() {
        return Mono.just(BaseResp.success());
    }

    @PostMapping(path = "/post")
    public Mono<BaseResp> post() {
        return Mono.just(BaseResp.success());
    }

}