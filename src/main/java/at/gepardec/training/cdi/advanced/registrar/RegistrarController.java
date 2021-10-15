package at.gepardec.training.cdi.advanced.registrar;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.UUID;

/**
 * this controller fires the asynchronous events which results we need to capture.
 */
@Path("/advanced/registrar")
@RequestScoped
@Controller
public class RegistrarController {

    @Inject
    private EventResultRegistrar eventResultRegistrar;

    @Inject
    private Event<EventData> event;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        fillData();

        return "advanced/registrar.xhtml";
    }

    @Path("/clear")
    @GET
    public String clear() {
        eventResultRegistrar.clear();

        return get();
    }

    @Path("/fire/{fail}")
    @PathParam("fail")
    @GET
    public String fire(@PathParam("fail") String fail) {
        event.fireAsync(EventData.of(UUID.randomUUID().toString(), "failedEvent".equals(fail)));

        return get();
    }

    private void fillData() {
        model.put("failedEvents", eventResultRegistrar.failedEvents());
        model.put("successEvents", eventResultRegistrar.successEvents());
    }
}
