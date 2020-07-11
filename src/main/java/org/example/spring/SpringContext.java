package org.example.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContext {

    @Bean
    public SuperObject superObject(@Qualifier("c") B b) {
        return new SuperObject(b);
    }

}
