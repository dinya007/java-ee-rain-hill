package ru.tisov.denis.crx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.tisov.denis.crx.service.RainyHillService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Api("Rainy hill controller")
@Path("/calculate")
public class RainyHillController {

    @Inject
    private RainyHillService rainyHillService;

    @GET
    @Produces("text/plain")
    @ApiOperation(value = "Calculate rainy hills", response = Integer.class)
    public int get(@QueryParam("hills") List<Integer> hills) {
        return rainyHillService.calculate(hills);
    }

}
