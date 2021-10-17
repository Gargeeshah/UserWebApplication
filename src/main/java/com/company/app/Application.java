package com.company.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleContextResolver;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
      
    }
        @Bean
        LocaleContextResolver localeResolver () {
            SessionLocaleResolver l = new SessionLocaleResolver();
            AcceptHeaderLocaleTzCompositeResolver r = new
                      AcceptHeaderLocaleTzCompositeResolver(l);
            return r;
        }
        
}
    

