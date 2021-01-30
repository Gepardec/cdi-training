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

    @Inject
    private RequestScopedBean requestScopedBean;

    @Inject
    private SessionScopedBean sessionScopedBean;

    @Inject
    private ApplicationScopedBean applicationScopedBean;

    @Inject
    private ScopeMixApplication scopeMixApplication;

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

//
//
//  @Inject
//  @ResourcePath("scopes/scopesdependent.html")
//  Template scopedependent;
//
//  @Inject
//  SecondApplicationScopedBean secondApplicationScopedBean;
//
//  @GET
//  @Path("/dependent")
//  public TemplateInstance dependent() {
//    return scopedependent.
//        data("dependentBeanRequestScoped", requestScopedBean.getDependentBean()).
//        data("dependentBeanRequestScopedValue", requestScopedBean.getDependentBean().getValue()).
//        data("dependentBeanSessionScoped", sessionScopedBean.getDependentBean()).
//        data("dependentBeanSessionScopedValue", sessionScopedBean.getDependentBean().getValue()).
//        data("dependentBeanApplicationScoped", applicationScopedBean.getDependentBean()).
//        data("dependentBeanApplicationScopedValue", applicationScopedBean.getDependentBean().getValue()).
//        data("dependentBeanSecondApplicationScoped", secondApplicationScopedBean.getDependentBean()).
//        data("dependentBeanSecondApplicationScopedValue", secondApplicationScopedBean.getDependentBean().getValue());
//  }

}
