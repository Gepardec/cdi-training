package at.gepardec.cditraining;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class RootController {

    @Path("/")
    @GET
    @Controller
    public String get() {
        return welcome();
    }

    @Path("/welcome")
    @GET
    @Controller
    public String welcome() {
        return "welcome.html";
    }

    @Path("/index")
    @GET
    @Controller
    public String index() {
        return "index.html";
    }
}
