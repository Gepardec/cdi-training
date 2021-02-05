package at.gepardec.cditraining.initialization;


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
        model.put("requestValue", requestBean);
        model.put("sessionValue", sessionBean);
        model.put("applicationValue", applicationBean);

        return "initialization/initialization.html";
    }
}
