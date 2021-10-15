package at.gepardec.training.cdi.basic.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/scopes/dependent")
@RequestScoped
@Controller
public class ScopesDependentController {

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
    public String dependent() {
        model.put("dependentBeanRequestScopedValue", requestBean.dependentBean().incrementAndGet());
        model.put("dependentBeanSessionScopedValue", sessionBean.dependentBean().incrementAndGet());
        model.put("dependentBeanApplicationScopedValue", applicationBean.dependentBean().incrementAndGet());

        return "basic/scopes-dependent.xhtml";
    }
}
