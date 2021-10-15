package at.gepardec.training.cdi.basic.events;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
