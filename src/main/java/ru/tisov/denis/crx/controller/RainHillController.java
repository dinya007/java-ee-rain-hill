package ru.tisov.denis.crx.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/calc")
public class RainHillController {

    @GET
    public String get() {
        return "Hello!";
    }

}
