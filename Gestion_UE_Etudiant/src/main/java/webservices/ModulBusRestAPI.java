package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bus")
public class ModulBusRestAPI {
    static ModuleBusiness helper=new ModuleBusiness();
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
    @Path("/list/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(@PathParam("matricule") String matricule) {
        return Response.status(200).entity(helper.getModuleByMatricule(matricule)).build();
    }
    @Path("/{mat}")
    @DELETE
    public Response deleteModule(@PathParam("mat") String mat) {
        if(helper.deleteModule(mat)){
            return Response.status(200).entity("deleted").build();
        }
        else
            return Response.status(400).entity("not found").build();
    }
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMBByType(@QueryParam("type") Module.TypeModule type) {
        return Response.status(200).entity(helper.getModulesByType(type)).build();
    }
    @Path("/{mat}")
    @DELETE
    public Response deleteMB(@PathParam("mat") String mat) {
        if(helper.deleteModule(mat)){
            return Response.status(200).entity("deleted").build();
        }
        else
            return Response.status(400).entity("not found").build();
    }
}
