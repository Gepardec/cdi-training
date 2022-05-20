package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

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
