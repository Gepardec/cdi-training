package at.gepardec.training.cdi.advanced.startupevent;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/startup-event")
@RequestScoped
@Controller
public class StartupEventController {

    @Path("/")
    @GET
    public String get() {
        return "advanced/startup-event.xhtml";
    }
}
