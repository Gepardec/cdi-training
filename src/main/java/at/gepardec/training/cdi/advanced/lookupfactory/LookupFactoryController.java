package at.gepardec.training.cdi.advanced.lookupfactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
