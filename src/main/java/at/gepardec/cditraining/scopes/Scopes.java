package at.gepardec.cditraining.scopes;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/scopes")
@Produces(MediaType.TEXT_HTML)
public class Scopes {

  @Inject
  @ResourcePath("scopes/scopesbasic.html")
  Template scopesbasic;
  @Inject
  RequestScopedBean requestScopedBean;
  @Inject
  SessionScopedBean sessionScopedBean;
  @Inject
  ApplicationScopedBean applicationScopedBean;

  @GET
  @Path("/basic")
  public TemplateInstance basic() {
    return scopesbasic.
        data("requestScopedValue", requestScopedBean.getValue()).
        data("sessionScopedValue", sessionScopedBean.getValue()).
        data("applicationScopedValue", applicationScopedBean.getValue());
  }


  @Inject
  ScopeMixApplication scopeMixApplication;
  @Inject
  @ResourcePath("scopes/scopesadvanced.html")
  Template scopeadvanced;

  @GET
  @Path("/advanced")
  public TemplateInstance advanced() {
    return scopeadvanced.
        data("requestScopedValue", scopeMixApplication.getScopeMixSession().getScopeMixRequest().getValue()).
        data("sessionScopedValue", scopeMixApplication.getScopeMixSession().getValue()).
        data("applicationScopedValue", scopeMixApplication.getValue());
  }


  @Inject
  @ResourcePath("scopes/scopesdependent.html")
  Template scopedependent;

  @Inject
  SecondApplicationScopedBean secondApplicationScopedBean;

  @GET
  @Path("/dependent")
  public TemplateInstance dependent() {
    return scopedependent.
        data("dependentBeanRequestScoped", requestScopedBean.getDependentBean()).
        data("dependentBeanRequestScopedValue", requestScopedBean.getDependentBean().getValue()).
        data("dependentBeanSessionScoped", sessionScopedBean.getDependentBean()).
        data("dependentBeanSessionScopedValue", sessionScopedBean.getDependentBean().getValue()).
        data("dependentBeanApplicationScoped", applicationScopedBean.getDependentBean()).
        data("dependentBeanApplicationScopedValue", applicationScopedBean.getDependentBean().getValue()).
        data("dependentBeanSecondApplicationScoped", secondApplicationScopedBean.getDependentBean()).
        data("dependentBeanSecondApplicationScopedValue", secondApplicationScopedBean.getDependentBean().getValue());
  }

}
