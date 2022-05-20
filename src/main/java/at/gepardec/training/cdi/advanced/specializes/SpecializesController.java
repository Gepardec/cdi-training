package at.gepardec.training.cdi.advanced.specializes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/specializes")
@RequestScoped
@Controller
public class SpecializesController {

    /**
     * No need to know which implementation we use during compile time
     */
    @Inject
    private Service service;

    /**
     * Still we get {@link ServiceSpecialized} because we inherit from it, this is who the overwrite works
     */
    @Inject
    private ServiceOriginal serviceOriginal;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        model.put("result", service.execute());
        model.put("resultOriginal", serviceOriginal.execute());
        return "advanced/specializes.xhtml";
    }
}
