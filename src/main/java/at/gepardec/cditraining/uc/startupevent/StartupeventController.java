package at.gepardec.cditraining.uc.startupevent;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/uc/startupevent")
@RequestScoped
@Controller
public class StartupeventController {

    @Path("/")
    @GET
    public String get() {
        return "uc/startupevent/startupevent.html";
    }
}
