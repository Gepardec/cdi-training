package at.gepardec.training.cdi.basic.decorators;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/decorators")
@RequestScoped
@Controller
public class DecoratorsController {

    @Inject
    private ServiceApi service;

    @Path("/")
    @GET
    public String get() {
        service.decorated();
        service.nonDecorated();
        return "basic/decorators.xhtml";
    }
}
