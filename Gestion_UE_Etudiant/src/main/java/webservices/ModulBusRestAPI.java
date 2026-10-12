package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bus")
public class ModulBusRestAPI {
    private ModuleBusiness helper=new ModuleBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUE() {
        return Response.status(200).entity(helper.getAllModules()).build();
    }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addModule(Module module) {
        if (helper.addModule(module)){
            return Response.status(200).entity("Module added successfully!").build();
        }
        return Response.status(400).entity("Module already exists!").build();
    }
}
