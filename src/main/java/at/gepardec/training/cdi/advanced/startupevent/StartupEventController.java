package at.gepardec.training.cdi.advanced.startupevent;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

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
