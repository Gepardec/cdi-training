package at.gepardec.cditraining.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/interceptors")
@RequestScoped
@Controller
@FirstIntercept
@SecondIntercept
public class InterceptorsResource {

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

    @GET
    @Path("/logging")
    public String logging() {
        return VIEW_NAME;
    }

    @GET
    @Path("/loggedAndHandled")
    public String loggedAndHandled() {
        throw new RuntimeException("error");
    }

    @GET
    @Path("/error")
    public String error() {
        throw new RuntimeException("error");
    }
}
