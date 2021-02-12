package at.gepardec.cditraining.uc;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/uc")
@RequestScoped
public class IndexController {

    @Path("/index")
    @GET
    @Controller
    public String index() {
        return "uc/index.html";
    }
}
