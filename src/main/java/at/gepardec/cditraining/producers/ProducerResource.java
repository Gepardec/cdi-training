package at.gepardec.cditraining.producers;

import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/producers")
@RequestScoped
@Controller
public class ProducerResource {

    @Inject
    private Models model;

    @Inject
    private String myProducedString;

    @Inject
    private Logger logger;

    @Inject
    private ProducedBean producedBean;

    @GET
    @Path("/")
    public String get() {
        logger.info("The logger got produced");
        logger.info("ProducedBean value: " + producedBean.getValue() + " ProducedBean: " + producedBean);

        model.put("myProducedString", myProducedString);
        model.put("producedBeanValue", producedBean.getValue());
        model.put("producedBeanClass", producedBean);

        return "producers/producers.html";
    }
}
