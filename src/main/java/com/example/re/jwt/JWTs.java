package com.example.re.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class JWTs {

    public static String createToken(String uid) {
        try {
            Date now = new Date();
            Date after = new Date(now.getTime() + 24 * 60 * 60 * 1000);
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("www.master.me")
                    .withIssuedAt(now)
                    .withSubject("re")
                    .withAudience("app")
                    .withExpiresAt(after)
                    .withClaim("uid", uid)
                    .withJWTId(UUID.randomUUID().toString())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean verify(String jwtToken) {
        if (Objects.isNull(jwtToken))
            return false;

        try {
            JWT.require(Algorithm.HMAC256("secret"))
                    .withIssuer("www.master.me")
                    .withSubject("re")
                    .withAudience("app")
                    .build()
                    .verify(jwtToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static DecodedJWT decode(String jwtToken) {
        try {
            return JWT.decode(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUid(String jwtToken) {
        try {
            return JWT.decode(jwtToken).getClaim("uid").asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
