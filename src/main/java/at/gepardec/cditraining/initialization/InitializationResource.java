package at.gepardec.cditraining.initialization;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/initialization")
@Produces(MediaType.TEXT_HTML)
public class InitializationResource {

  @Inject
  @ResourcePath("initialization/initializationbasic.html")
  Template              initializationbasic;
  @Inject
  InitRequestScopedBean initRequestScopedBean;
  @Inject
  InitSessionScopedBean initSessionScopedBean;
  @Inject
  InitApplicationScopedBean initApplicationScopedBean;

  @GET
  @Path("/basic")
  public TemplateInstance basic() {
    return initializationbasic.instance();
  }

  @POST
  @Path("/initrequest")
  public TemplateInstance initRequest(){
    return initializationbasic.data("requestScopedValue", initRequestScopedBean);
  }

  @POST
  @Path("/initsession")
  public TemplateInstance initSession(){
    return initializationbasic.data("sessionScopedValue", initSessionScopedBean);
  }

  @POST
  @Path("/initapplication")
  public TemplateInstance initApplication(){
    return initializationbasic.data("applicationScopedValue", initApplicationScopedBean);
  }
}
