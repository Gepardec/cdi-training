package at.gepardec.training.cdi.basic.decorators;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
