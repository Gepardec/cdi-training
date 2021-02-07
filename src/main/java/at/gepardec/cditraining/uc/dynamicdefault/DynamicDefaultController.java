package at.gepardec.cditraining.uc.dynamicdefault;

import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/uc/dynamicdefault")
@RequestScoped
@Controller
public class DynamicDefaultController {

    @Inject
    private ServiceProducer serviceProducer;

    @Inject
    @Default // Without '@Default' you would actually declare '@Any' which means give me any bean implementation
    private Service service;

    @Inject
    private Logger log;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        return get(null);
    }

    @Path("/{type}")
    @PathParam("type")
    @GET
    public String get(@PathParam("type") String type) {
        if (type != null && !type.isEmpty()) {
            log.info("Switching implementation from '" + serviceProducer.getImplementationType() + "' -> '" + type + "'");
            serviceProducer.setImplementationType(type);
        }
        model.put("result", service.execute());
        return "uc/dynamicdefault/dynamicdefault.html";
    }
}
