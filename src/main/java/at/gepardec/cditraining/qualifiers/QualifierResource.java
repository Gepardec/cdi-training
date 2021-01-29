package at.gepardec.cditraining.qualifiers;

//import io.quarkus.qute.Template;
//import io.quarkus.qute.TemplateInstance;
//import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/qualifiers")
@Produces(MediaType.TEXT_HTML)
public class QualifierResource {

//  @Inject
//  @ResourcePath("qualifiers/qualifiers.html")
//  Template qualifiersbasic;
//
//  @Inject
//  Shape circle;
//
//  @Inject
//  Shape rectangle;
//
//  @GET
//  @Path("/basic")
//  public TemplateInstance basic() {
//    return qualifiersbasic.
//        data("circle", circle).
//        data("rectangle", rectangle);
//  }
}
