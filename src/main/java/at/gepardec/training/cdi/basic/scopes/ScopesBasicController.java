package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Fix the scopes of the injected beans
 */
@Path("/basic/scopes/basic")
@RequestScoped
@Controller
public class ScopesBasicController {

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
    public String getBasic() {
        model.put("tabTitle", "Scopes Basic");
        model.put("requestValue", requestBean.incrementAndGet());
        model.put("sessionValue", sessionBean.incrementAndGet());
        model.put("applicationValue", applicationBean.incrementAndGet());

        return "basic/scopes-basic.xhtml";
    }

}
