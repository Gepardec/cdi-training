package at.gepardec.cditraining.inject;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Here two things are wrong. Are you up to find them?
 */
@Path("/inject-constructor")
@RequestScoped
@Controller
public class InjectConstructorResource {

    private final InjectModel model;

    public InjectConstructorResource() {
        this(null);
    }

    public InjectConstructorResource(InjectModel model) {
        this.model = model;
    }

    @GET
    public String get() {
        model.setForView("Your name goes here aas well :)");
        return "inject/inject-constructor.html";
    }
}
