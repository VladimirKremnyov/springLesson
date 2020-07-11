package org.example.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("super-puper-c")
public class C implements B {
    @Override
    public void doSmth() {
        System.out.println("Doing something from C");
    }
}
