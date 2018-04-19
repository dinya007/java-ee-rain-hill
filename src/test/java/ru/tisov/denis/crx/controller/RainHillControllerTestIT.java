package ru.tisov.denis.crx.controller;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tisov.denis.crx.RainHillApplication;
import ru.tisov.denis.crx.service.InMemoryRainHillService;
import ru.tisov.denis.crx.service.RainHillService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class RainHillControllerTestIT {

    @ArquillianResource
    private URL baseUrl;
    private Client client = ClientBuilder.newClient();
    private String calcPath = "rain-hill/calc";

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClass(RainHillApplication.class).
                addClass(RainHillController.class).
                addClass(RainHillService.class).
                addClass(InMemoryRainHillService.class);
    }

    @Test
    public void testCalcGet() throws MalformedURLException {
        Invocation.Builder request = client.target(URI.create(new URL(baseUrl, calcPath).toExternalForm()))
                .queryParam("hills", 2, 0, 1)
                .request();

        Integer response = request.get(Integer.class);

        assertEquals(1, response.intValue());
    }

}