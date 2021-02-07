package at.gepardec.cditraining.uc.alternatives;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/uc/alternatives")
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
        return "uc/alternatives/alternatives.html";
    }
}
