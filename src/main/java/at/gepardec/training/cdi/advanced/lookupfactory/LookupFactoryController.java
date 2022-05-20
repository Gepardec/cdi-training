package at.gepardec.training.cdi.advanced.lookupfactory;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/advanced/lookup-factory")
@RequestScoped
@Controller
public class LookupFactoryController {

    @Inject
    private Models model;

    @Inject
    private ServiceFactory serviceFactory;

    @Path("/{type}")
    @PathParam("type")
    @GET
    public String get(@PathParam("type") String type) {
        model.put("result", serviceFactory.forType(type).execute());
        return "advanced/lookup-factory.xhtml";
    }
}
