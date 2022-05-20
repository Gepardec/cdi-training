package at.gepardec.training.cdi.basic.initialization;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Implement a lifecycle callback methods in the injected beans.
 */
@Path("/basic/initialization")
@Controller
public class InitializationController {

    @Inject
    private NormalScopedBean requestBean;

    @Inject
    private DependentBean dependentBean;

    /**
     * Remember that CDI beans are initialized lazily, maybe you need to do something else in this method.
     */
    @GET
    @Path("/")
    public String get() {
        return "basic/initialization.xhtml";
    }
}
