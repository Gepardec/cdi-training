package at.gepardec.training.cdi.advanced.alternatives;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/alternatives")
@RequestScoped
@Controller
public class AlternativesController {

    /**
     * No need to know which implementation we use during compile time
     */
    @Inject
    private Service service;

    @Inject
    private ServiceProd serviceProd;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        model.put("result", service.execute());
        model.put("resultOriginal", serviceProd.execute());
        return "advanced/alternatives.xhtml";
    }
}
