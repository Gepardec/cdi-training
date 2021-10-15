package at.gepardec.training.cdi.basic.initialization;

import at.gepardec.training.cdi.Util;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/initialization")
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

        return "basic/initialization.xhtml";
    }
}
