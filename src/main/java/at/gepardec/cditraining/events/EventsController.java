package at.gepardec.cditraining.events;


import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/events")
@Controller
@RequestScoped
public class EventsController {

    @GET
    @Path("/")
    public String get() {
        return "events/events.html";
    }
}
