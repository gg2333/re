package com.example.re.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MySecurityAdapter extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private CaptchaAuthenticationProvider captchaAuthenticationProvider;

    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        //return super.authenticationManager();
//
//        List<AuthenticationProvider> providers = Collections.singletonList(new JwtTokenProvider());
//        return new ProviderManager(providers);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        /* 内存 */
        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("123456").roles("USER");

        /* 自定义用户存储 */
//        auth.userDetailsService(new MyUserDetailService())
//                .passwordEncoder(passwordEncoder());

        /* 自定义身份验证 */
//        auth.authenticationProvider(captchaAuthenticationProvider);
        auth.authenticationProvider(tokenAuthenticationProvider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        /* CSRF */
        http.csrf().disable();

        /* Session */
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        /* 禁用缓存 */
        http.headers().cacheControl();

        http.authorizeRequests()
                .antMatchers("/public/**")
                .permitAll()
                .antMatchers("/login/**")
                .permitAll()
                .anyRequest()
                .authenticated();


//        CaptchaAuthenticationFilter captchaAuthenticationFilter = new CaptchaAuthenticationFilter();
//        captchaAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        http.addFilterBefore(captchaAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //http.addFilter(new TokenAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new TokenAuthenticationFilter(authenticationManager()), LogoutFilter.class);

    }


}
