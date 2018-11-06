package com.example.re.conf;

import com.example.re.token.CheckInterceptor;
import com.example.re.token.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class HttpConf extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        /* check */
        registry.addInterceptor(new CheckInterceptor()).addPathPatterns("/**");

        /* token */
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        /* resource */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);
    }

}
