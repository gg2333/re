package com.example.re.security;

import com.example.re.jwt.JWTs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TokenAuthenticationFilter extends BasicAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

//    private List<GrantedAuthority> authorities =
//            Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

//    private List<GrantedAuthority> authorities =
//            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    private List<GrantedAuthority> authorities = Arrays.asList(
            new SimpleGrantedAuthority("ROLE_ADMIN"),
            new SimpleGrantedAuthority("ROLE_USER")
    );

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //super.doFilterInternal(request, response, chain);

        log.info("TokenAuthenticationFilter");

        /* JWT Token */
        String jwtToken = request.getHeader("Authorization");

        if (jwtToken == null || jwtToken.equals("") || !JWTs.verify(jwtToken)) {
            chain.doFilter(request, response);
            return;
        }

        /* save authentication */
        try {
            TokenAuthenticationToken authRequest =
                    new TokenAuthenticationToken("admin", "123456", authorities);

            Authentication authResult = this.getAuthenticationManager()
                    .authenticate(authRequest);

            SecurityContextHolder.getContext().setAuthentication(authResult);

        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        chain.doFilter(request, response);
    }

}
