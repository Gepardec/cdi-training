package at.gepardec.training.cdi.basic.inject;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Here two things are wrong. Are you up to find them?
 */
@Path("/basic/inject/constructor")
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
    @Path("/")
    public String get() {
        model.setForView("Your name goes here aas well :)");
        return "basic/inject-constructor.xhtml";
    }
}
