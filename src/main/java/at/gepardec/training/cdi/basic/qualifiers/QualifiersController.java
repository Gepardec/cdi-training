package at.gepardec.training.cdi.basic.qualifiers;

import at.gepardec.training.cdi.Util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Implement a CDI qualifier ensure tha the injected field 'rectangle' is a RectangleShape instance.
 * Don't change the type of the fields.
 */
@Path("/basic/qualifiers")
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

        return "basic/qualifiers.xhtml";
    }
}
