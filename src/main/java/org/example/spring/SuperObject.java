package org.example.spring;

import org.springframework.beans.factory.annotation.Qualifier;

public class SuperObject {

    private final B b;

    public SuperObject(@Qualifier("super-puper-c") B b) {
        this.b = b;
        System.out.println("Hello from SuperObject constructor");
    }
}
