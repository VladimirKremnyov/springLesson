package org.example.spring;

import org.springframework.stereotype.Component;

@Component
public class D implements B {
    @Override
    public void doSmth() {
        System.out.println("Doing something from D");
    }
}
