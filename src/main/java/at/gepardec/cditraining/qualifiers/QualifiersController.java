package at.gepardec.cditraining.qualifiers;

import at.gepardec.cditraining.Util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/qualifiers")
@RequestScoped
@Controller
public class QualifiersController {

    @Inject
    private Models model;

    @Inject
    private Shape circle;

    @Inject
    private Shape rectangle;

    @GET
    @Path("/")
    public String get() {
        model.put("circle", Util.nameWithoutProxy(circle));
        model.put("rectangle", Util.nameWithoutProxy(rectangle));

        return "qualifiers/qualifiers.html";
    }
}
