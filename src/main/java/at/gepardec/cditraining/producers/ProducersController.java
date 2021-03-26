package at.gepardec.cditraining.producers;

import at.gepardec.cditraining.Util;
import at.gepardec.cditraining.qualifiers.Circle;
import at.gepardec.cditraining.qualifiers.Rectangle;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/producers")
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
        model.put("circleList", Util.namesWithInstanceId(List.of(new Circle(), new Circle())));
        model.put("rectangleList", Util.namesWithInstanceId(List.of(new Rectangle(), new Rectangle())));

        model.put("producedString", producedString);
        model.put("producedBean", Util.nameWithInstanceId(producedBean));

        return "producers/producers.html";
    }
}
