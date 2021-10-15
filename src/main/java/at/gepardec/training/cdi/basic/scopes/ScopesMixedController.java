package at.gepardec.training.cdi.basic.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/scopes/mixed")
@RequestScoped
@Controller
public class ScopesMixedController {

    @Inject
    private Models model;

    // Mixed Scopes Example
    @Inject
    private MixedApplicationBean mixedApplicationBean;

    @GET
    @Path("/")
    public String advanced() {
        model.put("tabTitle", "Mixed Scopes");
        model.put("requestValue", mixedApplicationBean.scopeMixSession().scopeMixRequest().incrementAndGet());
        model.put("sessionValue", mixedApplicationBean.scopeMixSession().incrementAndGet());
        model.put("applicationValue", mixedApplicationBean.incrementAndGet());

        return "basic/scopes-basic-mixed.xhtml";
    }
}
