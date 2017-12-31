package com.lucassartori;

import com.lucassartori.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by sartori on 15/10/2017
 */

@SpringBootApplication
public class TokenBackendApplication {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/rest/*");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(TokenBackendApplication.class, args);
    }
}
