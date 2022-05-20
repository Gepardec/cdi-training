package at.gepardec.training.cdi.basic.interceptors;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/interceptors")
@RequestScoped
@Controller
@SecondIntercept
@FirstIntercept
public class InterceptorsController {

    @GET
    @Path("/")
    @SecondIntercept
    public String basic() {
        return "basic/interceptors.xhtml";
    }
}
