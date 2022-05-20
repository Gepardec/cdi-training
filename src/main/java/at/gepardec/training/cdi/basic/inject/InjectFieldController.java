package at.gepardec.training.cdi.basic.inject;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * What's going on wrong in this endpoint, so that it fails?
 */
@Path("/basic/inject/field")
@RequestScoped
@Controller
public class InjectFieldController {

    private InjectModel model = new InjectModel();

    @GET
    @Path("/")
    public String get() {
        model.setForView("Your name goes here as well :)");
        return "basic/inject-field.xhtml";
    }
}
