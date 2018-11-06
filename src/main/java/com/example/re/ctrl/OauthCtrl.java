package com.example.re.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/tests")
public class OauthCtrl {

    @GetMapping(path = "/get")
    public Mono<String> get() {
        return Mono.just("Hello");
    }


}