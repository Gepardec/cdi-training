package at.gepardec.training.cdi.advanced.registrar;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
