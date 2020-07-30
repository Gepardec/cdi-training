package at.gepardec.cditraining.firststeps;

import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/constructorinject")
public class ConstructorInject {

    InjectMe injectMeInTheConstructor;

    public ConstructorInject(){
        // i am here because of quarkus simplifies things
        // https://quarkus.io/guides/cdi-reference#simplified-constructor-injection
    }

    ConstructorInject(InjectMe injectMe){
        injectMeInTheConstructor = injectMe;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance hello() {
        return injectMeInTheConstructor.constructorinject();
    }
}
