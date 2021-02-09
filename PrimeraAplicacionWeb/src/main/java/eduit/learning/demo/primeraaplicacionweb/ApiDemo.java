package eduit.learning.demo.primeraaplicacionweb;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("demo")
@RequestScoped
public class ApiDemo {


    public ApiDemo() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/json/{id}")
    public String getJson(int id) {
        return "Estoy dentro del método getJson y el id es: " + id;
    }

    @GET
    @Path("getMessage")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage() {
        return "Esto dentro del método getMessage";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
