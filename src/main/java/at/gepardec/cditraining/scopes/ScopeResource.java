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
public class ScopeResource {

    @Inject
    private Models model;

    // Scope Basic Example
    @Inject
    private RequestScopedBean requestScopedBean;

    @Inject
    private SessionScopedBean sessionScopedBean;

    @Inject
    private ApplicationScopedBean applicationScopedBean;

    // Scope Advanced Example
    @Inject
    private ScopeMixApplication scopeMixApplication;

    // Scope Dependent Example
    @Inject
    private SecondApplicationScopedBean secondApplicationScopedBean;

    @GET
    @Path("/basic")
    public String getBasic() {
        model.put("scopesType", "Basic");
        model.put("requestScopedValue", requestScopedBean.incrementAndGet());
        model.put("sessionScopedValue", sessionScopedBean.incrementAndGet());
        model.put("applicationScopedValue", applicationScopedBean.incrementAndGet());

        return "scopes/scopes.html";
    }

    @GET
    @Path("/advanced")
    public String advanced() {
        model.put("scopesType", "Advanced");
        model.put("requestScopedValue", scopeMixApplication.scopeMixSession().scopeMixRequest().incrementAndGet());
        model.put("sessionScopedValue", scopeMixApplication.scopeMixSession().incrementAndGet());
        model.put("applicationScopedValue", scopeMixApplication.incrementAndGet());

        return "scopes/scopes.html";
    }

    @GET
    @Path("/dependent")
    public String dependent() {
        model.put("dependentBeanRequestScoped", requestScopedBean.dependentBean());
        model.put("dependentBeanRequestScopedValue", requestScopedBean.dependentBean().incrementAndGet());
        model.put("dependentBeanSessionScoped", sessionScopedBean.dependentBean());
        model.put("dependentBeanSessionScopedValue", sessionScopedBean.dependentBean().incrementAndGet());
        model.put("dependentBeanApplicationScoped", applicationScopedBean.dependentBean());
        model.put("dependentBeanApplicationScopedValue", applicationScopedBean.dependentBean().incrementAndGet());
        model.put("dependentBeanSecondApplicationScoped", secondApplicationScopedBean.dependentBean());
        model.put("dependentBeanSecondApplicationScopedValue", secondApplicationScopedBean.dependentBean().incrementAndGet());

        return "scopes/scopes-dependent.html";
    }
}
