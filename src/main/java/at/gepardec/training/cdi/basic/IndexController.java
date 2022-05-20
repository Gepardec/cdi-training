package at.gepardec.training.cdi.basic;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/index")
@RequestScoped
@Controller
public class IndexController {

    @Path("/")
    @GET
    public String index() {
        return "basic/index.xhtml";
    }
}
