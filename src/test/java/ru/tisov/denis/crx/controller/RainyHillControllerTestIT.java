package ru.tisov.denis.crx.controller;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tisov.denis.crx.RainyHillApplication;
import ru.tisov.denis.crx.service.InMemoryRainyHillService;
import ru.tisov.denis.crx.service.RainyHillService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class RainyHillControllerTestIT {

    @ArquillianResource
    private URL baseUrl;
    private Client client = ClientBuilder.newClient();
    private String calcPath = "rainy-hill/calculate";

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClass(RainyHillApplication.class).
                addClass(RainyHillController.class).
                addClass(RainyHillService.class).
                addClass(InMemoryRainyHillService.class);
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