package at.gepardec.training.cdi.basic.qualifiers;

import at.gepardec.training.cdi.Util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

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
