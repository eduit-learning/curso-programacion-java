package eduit.learning.demo.primeraaplicacionweb;

import java.util.ArrayList;
import java.util.List;
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
    public List<Empleado> getJson(@PathParam("id") int id) {
        List<Empleado> nombres= new ArrayList<>();
        nombres.add(new Empleado("Abraham", 123));
        nombres.add(new Empleado("Pedro", 124));
        nombres.add(new Empleado("Juan", 125));
        nombres.add(new Empleado("Francisco", 126));
        
        return nombres;
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
