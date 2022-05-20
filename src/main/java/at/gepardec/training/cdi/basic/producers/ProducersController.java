package at.gepardec.training.cdi.basic.producers;

import at.gepardec.training.cdi.Util;
import at.gepardec.training.cdi.basic.qualifiers.Circle;
import at.gepardec.training.cdi.basic.qualifiers.Rectangle;
import org.slf4j.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;

@Path("/basic/producers")
@RequestScoped
@Controller
public class ProducersController {

    @Inject
    private Models model;

    @Inject
    private String producedString;

    @Inject
    private Logger logger;

    @Inject
    private ProducedBean producedBean;

    @GET
    @Path("/")
    public String get() {
        // Here you put your produced lists in
        model.put("circleList", Util.namesWithInstanceId(List.of()));
        model.put("rectangleList", Util.namesWithInstanceId(List.of()));

        model.put("producedString", producedString);
        model.put("producedBean", Util.nameWithInstanceId(producedBean));

        return "basic/producers.xhtml";
    }
}
