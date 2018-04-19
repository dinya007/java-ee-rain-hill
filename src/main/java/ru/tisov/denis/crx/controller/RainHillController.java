package ru.tisov.denis.crx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.tisov.denis.crx.service.RainHillService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Api("Rain hill controller")
@Path("/calc")
public class RainHillController {

    @Inject
    private RainHillService rainHillService;

    @GET
    @Produces("text/plain")
    @ApiOperation(value = "Calculate rain hills", response = Integer.class)
    public int get(@QueryParam("hills") List<Integer> hills) {
        return rainHillService.calc(hills);
    }

}
