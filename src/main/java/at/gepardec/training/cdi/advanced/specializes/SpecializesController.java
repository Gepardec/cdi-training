package at.gepardec.training.cdi.advanced.specializes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
