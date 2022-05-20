package at.gepardec.training.cdi.advanced.dynamicdefault;

import org.slf4j.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/advanced/dynamic-default")
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
        return "advanced/dynamic-default.xhtml";
    }
}
