package ru.tisov.denis.crx.controller;

import ru.tisov.denis.crx.service.RainHillService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/calc")
public class RainHillController {

    @Inject
    private RainHillService rainHillService;

    @GET
    @Produces("text/plain")
    public int get(@QueryParam("hills") List<Integer> hills) {
        System.out.println(hills);
        return rainHillService.calc(hills);
    }

}
