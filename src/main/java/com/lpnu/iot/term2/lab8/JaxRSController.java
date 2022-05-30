package com.lpnu.iot.term2.lab8;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class JaxRSController {

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWorld() {
        return "Hello world";
    }
}
