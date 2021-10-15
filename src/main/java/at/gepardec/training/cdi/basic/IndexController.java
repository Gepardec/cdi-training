package at.gepardec.training.cdi.basic;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
