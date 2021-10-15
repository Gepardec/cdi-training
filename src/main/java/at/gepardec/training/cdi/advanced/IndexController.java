package at.gepardec.training.cdi.advanced;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
