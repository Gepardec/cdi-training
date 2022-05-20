package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Fix the scopes of the injected beans, as well as the scopes of beans they inject
 */
@Path("/basic/scopes/mixed")
@RequestScoped
@Controller
public class ScopesMixedController {

    @Inject
    private Models model;

    @Inject
    private MixedApplicationBean mixedApplicationBean;

    @GET
    @Path("/")
    public String advanced() {
        model.put("tabTitle", "Mixed Scopes");
        model.put("requestValue", mixedApplicationBean.scopeMixSession().scopeMixRequest().incrementAndGet());
        model.put("sessionValue", mixedApplicationBean.scopeMixSession().incrementAndGet());
        model.put("applicationValue", mixedApplicationBean.incrementAndGet());

        return "basic/scopes-mixed.xhtml";
    }
}
