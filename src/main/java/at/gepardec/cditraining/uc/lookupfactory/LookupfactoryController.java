package at.gepardec.cditraining.uc.lookupfactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/uc/lookupfactory")
@RequestScoped
@Controller
public class LookupfactoryController {

    @Inject
    private Models model;

    @Inject
    private ServiceFactory serviceFactory;

    @Path("/{type}")
    @PathParam("type")
    @GET
    public String get(@PathParam("type") String type) {
        model.put("result", serviceFactory.forType(type).execute());
        return "uc/lookupfactory/lookupfactory.html";
    }
}
