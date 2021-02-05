package at.gepardec.cditraining.scopes;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/scopes")
@RequestScoped
@Controller
public class ScopesController {

    @Inject
    private Models model;

    // Scope Basic Example
    @Inject
    private RequestBean requestBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private ApplicationBean applicationBean;

    // Scope Advanced Example
    @Inject
    private MixedApplicationBean mixedApplicationBean;

    // Scope Dependent Example
    @Inject
    private DependentApplicationBean dependentApplicationBean;

    @GET
    @Path("/basic")
    public String getBasic() {
        model.put("tabTitle", "Scopes Basic");
        model.put("requestValue", requestBean.incrementAndGet());
        model.put("sessionValue", sessionBean.incrementAndGet());
        model.put("applicationValue", applicationBean.incrementAndGet());

        return "scopes/scopes-basic-mixed.html";
    }

    @GET
    @Path("/mixed")
    public String advanced() {
        model.put("tabTitle", "Scopes Advanced");
        model.put("requestValue", mixedApplicationBean.scopeMixSession().scopeMixRequest().incrementAndGet());
        model.put("sessionValue", mixedApplicationBean.scopeMixSession().incrementAndGet());
        model.put("applicationValue", mixedApplicationBean.incrementAndGet());

        return "scopes/scopes-basic-mixed.html";
    }

    @GET
    @Path("/dependent")
    public String dependent() {
        model.put("tabTitle", "Scope Dependent");
        model.put("dependentBeanRequestScoped", requestBean.dependentBean());
        model.put("dependentBeanRequestScopedValue", requestBean.dependentBean().incrementAndGet());
        model.put("dependentBeanSessionScoped", sessionBean.dependentBean());
        model.put("dependentBeanSessionScopedValue", sessionBean.dependentBean().incrementAndGet());
        model.put("dependentBeanApplicationScoped", applicationBean.dependentBean());
        model.put("dependentBeanApplicationScopedValue", applicationBean.dependentBean().incrementAndGet());
        model.put("dependentBeanSecondApplicationScoped", dependentApplicationBean.dependentBean());
        model.put("dependentBeanSecondApplicationScopedValue", dependentApplicationBean.dependentBean().incrementAndGet());

        return "scopes/scopes-dependent.html";
    }
}
