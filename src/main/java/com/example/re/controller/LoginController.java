package com.example.re.controller;

import com.example.re.jwt.JWTs;
import com.example.re.resp.BaseResp;
import com.example.re.resp.LoginModel;
import com.example.re.rx.RxWrappers;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping(path = "/login")
    public Mono<BaseResp<LoginModel>>
    login(@RequestParam("username") String username,
          @RequestParam("password") String password) {

        String uid = "bd8a4e65-2aae-40f7-887b-4dd596112b52";
        LoginModel model = new LoginModel(uid);
        model.jwtToken = JWTs.createToken(uid);

        return Mono.just(model).flatMap(RxWrappers.baseWrapper());
    }

    @PostMapping(path = "/captcha")
    public Mono<BaseResp>
    captcha(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        return Mono.just(BaseResp.success());
    }

    @PostMapping(path = "/register")
    public Mono<BaseResp>
    register(@RequestParam("username") String username,
             @RequestParam("password") String password) {
        return Mono.just(BaseResp.success());
    }

}
