package com.example.re.controller;

import com.example.re.resp.BaseResp;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/get")
    public Mono<BaseResp<String>> get() {
        return Mono.just(BaseResp.success());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/post")
    public Mono<BaseResp<String>> post() {
        return Mono.just(BaseResp.success());
    }

    @GetMapping(path = "/test")
    public Mono<BaseResp<String>> test() {
        return Mono.just(BaseResp.success());
    }

}
