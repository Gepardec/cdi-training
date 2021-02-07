package at.gepardec.cditraining.decorators;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/decorators")
@RequestScoped
@Controller
public class DecoratorsController {

    @Inject
    private ServiceApi service;

    @Path("/")
    @GET
    public String get() {
        service.doSomething();
        service.doSomethingElse();
        return "decorators/decorators.html";
    }
}
