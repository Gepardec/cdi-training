package at.gepardec.training.cdi.basic.events;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/events")
@Controller
@RequestScoped
public class EventsController {

    @GET
    @Path("/")
    public String get() {
        return "basic/events.xhtml";
    }
}
