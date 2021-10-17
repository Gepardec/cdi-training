package at.gepardec.training.cdi.basic.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
