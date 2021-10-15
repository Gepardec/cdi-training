package at.gepardec.cditraining.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Here two things are wrong. Are you up to find them?
 */
@Path("/inject-constructor")
@RequestScoped
@Controller
public class InjectConstructorController {

    private InjectModel model;

    /**
     * Try to remove me and restart your server and see what happens
     */
    public InjectConstructorController() {
    }

    public InjectConstructorController(InjectModel model) {
        this.model = model;
    }

    @GET
    public String get() {
        model.setForView("Your name goes here aas well :)");
        return "inject/inject-constructor.html";
    }
}
