package at.gepardec.cditraining;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/index")
@RequestScoped
public class IndexController {

    @GET
    @Controller
    public String get() {
        return "index.html";
    }
}
