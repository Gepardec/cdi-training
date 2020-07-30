package at.gepardec.cditraining.firststeps;

import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/firstinject")
public class FirstInject {

    InjectMe injectMe = new InjectMe();

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance hello() {
        return injectMe.firstinject();
    }
}
