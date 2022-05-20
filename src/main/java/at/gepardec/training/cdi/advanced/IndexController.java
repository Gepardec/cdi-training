package at.gepardec.training.cdi.advanced;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/index")
@RequestScoped
public class IndexController {

    @Path("/")
    @GET
    @Controller
    public String index() {
        return "advanced/index.xhtml";
    }
}
