package at.gepardec.cditraining.initialization;


import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/initialization")
@Controller
public class InitializationResource {

    @Inject
    private Models model;

    @Inject
    private InitRequestScopedBean initRequestScopedBean;

    @Inject
    private InitSessionScopedBean initSessionScopedBean;

    @Inject
    private InitApplicationScopedBean initApplicationScopedBean;

    @GET
    @Path("/")
    public String get() {
        model.put("requestScopedValue", initRequestScopedBean);
        model.put("sessionScopedValue", initSessionScopedBean);
        model.put("applicationScopedValue", initApplicationScopedBean);

        return "initialization/initialization.html";
    }
}
