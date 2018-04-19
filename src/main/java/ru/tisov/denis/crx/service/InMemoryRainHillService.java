package ru.tisov.denis.crx.service;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RainHillService {

    public String calc() {
        return "Hello!";
    }

}
