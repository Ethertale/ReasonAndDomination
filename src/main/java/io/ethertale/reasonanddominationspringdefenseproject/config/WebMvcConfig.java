package io.ethertale.reasonanddominationspringdefenseproject.config;

import io.ethertale.reasonanddominationspringdefenseproject.security.SessionCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SessionCheckInterceptor sessionCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // ** - Всичко след
        registry.addInterceptor(sessionCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/js/**", "/imgs/**", "/fonts/**");
    }
}
