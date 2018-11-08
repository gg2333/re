package com.example.re.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(TokenAuthenticationProvider.class);

    private List<GrantedAuthority> authorities = Arrays.asList(
            new SimpleGrantedAuthority("ROLE_ADMIN"),
            new SimpleGrantedAuthority("ROLE_USER")
    );

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("TokenAuthenticationProvider");

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        /* 模拟数据库 */
        if (!username.equals("admin") || !password.equals("123456"))
            return null;

        return new TokenAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.info("TokenAuthenticationProvider supports");
        return TokenAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
