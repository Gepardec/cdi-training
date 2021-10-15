package at.gepardec.training.cdi;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
@Controller
public class WelcomeController {

    @Path("/")
    @GET
    public String get() {
        return welcome();
    }

    @Path("/welcome")
    @GET
    public String welcome() {
        return "welcome.xhtml";
    }
}
