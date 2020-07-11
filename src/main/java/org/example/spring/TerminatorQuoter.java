package org.example.spring;

import javax.annotation.PostConstruct;

public class TerminatorQuoter implements Quoter {

    @PostConstruct
    public void init() {

    }

    public TerminatorQuoter () {

    }

    private String message;
    @RandomInt(min = 2, max = 3)
    private int repeat;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < this.repeat; i++) {
            System.out.println(message);
        }
    }
}
