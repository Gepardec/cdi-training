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

    private static final String VIEW_NAME = "interceptors/interceptors.html";

    @GET
    @SecondIntercept
    public String basic() {
        return VIEW_NAME;
    }

    @GET
    @Path("/binding")
    @BindingInterceptor
    public String binding() {
        return VIEW_NAME;
    }
}
