package com.lpnu.iot.term2.lab8.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class JaxRSController {

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWorld() {
        return "Hello world";
    }
}
