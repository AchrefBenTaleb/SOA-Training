package webservices;

import metiers.ModuleBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
