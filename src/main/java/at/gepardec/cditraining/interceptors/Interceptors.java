package at.gepardec.cditraining.interceptors;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/interceptors")
@Produces(MediaType.TEXT_HTML)
@FirstIntercept
@SecondIntercept
public class Interceptors {

  @Inject
  @ResourcePath("interceptors/interceptors.html")
  Template interceptors;

  @GET
  public TemplateInstance basic() {
    return interceptors.instance();
  }

  @POST
  @Path("/error")
  public TemplateInstance error() {
    throw new RuntimeException("error");
  }

}
