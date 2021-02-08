package at.gepardec.cditraining.uc.registrar;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.UUID;

@Path("/uc/registrar")
@RequestScoped
@Controller
public class RegistrarController {

    private static final String VIEW_NAME = "uc/registrar/registrar.html";

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

        return VIEW_NAME;
    }

    @Path("/clear")
    @GET
    public String clear() {
        eventResultRegistrar.clear();
        fillData();

        return VIEW_NAME;
    }

    @Path("/fire/{fail}")
    @PathParam("fail")
    @GET
    public String fire(@PathParam("fail") String fail) {
        event.fireAsync(EventData.of(UUID.randomUUID().toString(), "failedEvent".equals(fail)));
        fillData();

        return VIEW_NAME;
    }

    private void fillData() {
        model.put("failedEvents", eventResultRegistrar.failedEvents());
        model.put("successEvents", eventResultRegistrar.successEvents());
    }
}
