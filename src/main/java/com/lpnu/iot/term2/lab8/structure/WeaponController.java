package com.lpnu.iot.term2.lab8.structure;


import com.lpnu.iot.term2.lab8.recources.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@RestController
@Path("/weapons")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;



    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Long, Weapon> getAllWeapons() {
        return weaponService.getWeapons();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weapon addWeapon(@PathParam("id") Long id) {
        return weaponService.getWeaponById(id);
    }

    @POST
    @Path("/add/{quality}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getWeaponById(@PathParam("quality") int quality) {
        weaponService.addWeapon(quality);
        return "Successfully added a new weapon";
    }

    @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateWeaponById(@PathParam("id") Long id,
                                   @DefaultValue("-1")
                                   @QueryParam("quality") int quality) {

        if(weaponService.updateWeapon(id, quality)) {
            return "Successfully updated a weapon with id " + id;
        } else {
            return "Error: Did not find any weapons with id " + id;
        }
    }


    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteWeaponById(@PathParam("id") Long id) {

        if(weaponService.deleteWeaponById(id)) {
            return "Successfully deleted an element with id " + id;
        } else {
            return "Error: there were no elements with id " + id;
        }
    }
}
