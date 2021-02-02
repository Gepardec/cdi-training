package at.gepardec.cditraining.qualifiers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/qualifiers")
@RequestScoped
@Controller
public class QualifierResource {

    @Inject
    private Models model;

    @Inject
    private Shape circle;

    @Inject
    private Shape rectangle;

    @GET
    @Path("/")
    public String get() {
        model.put("circle", circle);
        model.put("rectangle", rectangle);

        return "qualifiers/qualifiers.html";
    }
}
