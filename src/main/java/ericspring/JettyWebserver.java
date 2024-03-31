package ericspring;

import org.springframework.web.context.WebApplicationContext;

public class JettyWebserver implements WebServer{
    @Override
    public void getStart(WebApplicationContext applicationContext) {
        System.out.println("start Jetty Server");
    }
}
