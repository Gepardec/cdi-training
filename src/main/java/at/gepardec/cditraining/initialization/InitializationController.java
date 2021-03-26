package at.gepardec.cditraining.initialization;


import at.gepardec.cditraining.Util;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/initialization")
@Controller
public class InitializationController {

    @Inject
    private Models model;

    @Inject
    private RequestBean requestBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private ApplicationBean applicationBean;

    @GET
    @Path("/")
    public String get() {
        model.put("requestValue", Util.nameWithInstanceId(requestBean));
        model.put("sessionValue", Util.nameWithInstanceId(sessionBean));
        model.put("applicationValue", Util.nameWithInstanceId(applicationBean));

        return "initialization/initialization.html";
    }
}
