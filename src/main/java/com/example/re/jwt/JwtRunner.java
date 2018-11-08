package com.example.re.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JwtRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JwtRunner.class);

    @Override
    public void run(String... args) throws Exception {

//        String token = JWTs.createToken("bd8a4e65-2aae-40f7-887b-4dd596112b52");
//        log.info(token);
//
//        String t = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZSIsImF1ZCI6ImFwcCIsInVpZCI6ImJkOGE0ZTY1LTJhYWUtNDBmNy04ODdiLTRkZDU5NjExMmI1MiIsImlzcyI6Ind3dy5tYXN0ZXIubWUiLCJleHAiOjE1NDE3NTM4MDAsImlhdCI6MTU0MTY2NzQwMCwianRpIjoiNjlkYjAwYmMtNjYzMy00OTFkLTk4ZGUtN2YwYzEzMDVmNGI5In0.36SliMstrbyzPP4O9LeSmYkxjJyI0qHbXyOYUBDiF2I";
//        if (JWTs.verify(t)) {
//            DecodedJWT jwt = JWTs.decode(t);
//            if (jwt != null) {
//                log.info(jwt.getClaim("uid").asString());
//            }
//        }


//        String s = new BCryptPasswordEncoder().encode("123456");
//        log.info(s);

    }
}

/*
{
  "sub": "sino",
  "jti": "5f4ae85e-8b40-45cc-af20-95670f50b894",
  "sid": "5d735e19-03bd-41de-8ba8-1c9bde9977f6",
  "iat": 1542157182,
  "nbf": 1541552382,
  "exp": 1542157182,
  "iss": "http://api.sowl.cn",
  "aud": "app"
}
 */

/*
{
  "sub": "sino",
  "jti": "d34221a4-5ae0-44cf-998e-384b86552753",
  "sid": "c09de25e-34e6-4f54-ab8c-497ef2b94fd7",
  "iat": 1542158810,
  "nbf": 1541554010,
  "exp": 1542158810,
  "iss": "http://api.sowl.cn",
  "aud": "app"
}
 */