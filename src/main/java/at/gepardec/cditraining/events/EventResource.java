package at.gepardec.cditraining.events;

//import io.quarkus.qute.Template;
//import io.quarkus.qute.TemplateInstance;
//import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/events")
@Produces(MediaType.TEXT_HTML)
public class EventResource {

//    @Inject
//    @ResourcePath("events/events.html")
//    Template events;
//
//    @GET
//    public TemplateInstance get() {
//        return events.instance();
//    }
//
//    @GET
//    @Path("/eventSingle")
//    public TemplateInstance eventData() {
//        return events.instance();
//    }
//
//    @GET
//    @Path("/eventMultiple")
//    public TemplateInstance eventCommon() {
//        return events.instance();
//    }
}
