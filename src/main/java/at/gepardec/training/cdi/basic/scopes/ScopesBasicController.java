package at.gepardec.training.cdi.basic.scopes;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/scopes/basic")
@RequestScoped
@Controller
public class ScopesBasicController {

    @Inject
    private Models model;

    @Inject
    private RequestBean requestBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private ApplicationBean applicationBean;

    @GET
    @Path("/")
    public String getBasic() {
        model.put("tabTitle", "Scopes Basic");
        model.put("requestValue", requestBean.incrementAndGet());
        model.put("sessionValue", sessionBean.incrementAndGet());
        model.put("applicationValue", applicationBean.incrementAndGet());

        return "basic/scopes-basic-mixed.xhtml";
    }

}
