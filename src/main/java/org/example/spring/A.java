package org.example.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;

    public A(@Qualifier("d") B b) {
        this.b = b;
    }

    public void act() {
        b.doSmth();
    }
}
