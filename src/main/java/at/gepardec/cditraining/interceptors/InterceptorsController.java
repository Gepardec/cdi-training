package at.gepardec.cditraining.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/interceptors")
@RequestScoped
@Controller
@SecondIntercept
@FirstIntercept
public class InterceptorsController {

    @GET
    @SecondIntercept
    @BindingInterceptor
    public String basic() {
        return "interceptors/interceptors.html";
    }
}
