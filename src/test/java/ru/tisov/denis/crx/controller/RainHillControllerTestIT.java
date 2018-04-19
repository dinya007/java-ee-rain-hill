package ru.tisov.denis.crx.controller;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.tisov.denis.crx.RainHillApplication;
import ru.tisov.denis.crx.service.InMemoryRainHillService;
import ru.tisov.denis.crx.service.RainHillService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class RainHillControllerTestIT {

    private static WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class).
                addClass(RainHillApplication.class).
                addClass(RainHillController.class).
                addClass(RainHillService.class).
                addClass(InMemoryRainHillService.class);

        System.out.println(war.toString(true));

        return war;
    }

    @ArquillianResource
    private URL base;

    @Before
    public void setupClass() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "rain-hill/calc?hills=2&hills=0&hills=1").toExternalForm()));
    }

    @Test
    public void testCalcGet() {
        Integer response = target.request().get(Integer.class);
        assertEquals(1, response.intValue());
    }

}