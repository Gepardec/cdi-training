package at.gepardec.cditraining.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * What's going on wrong in this endpoint, so that it fails?
 */
@Path("/inject-field")
@RequestScoped
@Controller
public class InjectResource {

    private InjectModel model = new InjectModel();

    @GET
    @Path("/")
    public String get() {
        model.setForView("Your name goes here as well :)");
        return "inject/inject-field.html";
    }
}
