package at.gepardec.cditraining.producers;

//import io.quarkus.qute.Template;
//import io.quarkus.qute.TemplateInstance;
//import io.quarkus.qute.api.ResourcePath;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/producers")
@Produces(MediaType.TEXT_HTML)
public class ProducerResource {

//  @Inject
//  @ResourcePath("producers/producers.html")
//  Template producers;
//
//  @Inject
//  String myProducedString;
//
//  @Inject
//  Logger logger;
//
//  @Inject
//  ProducedBean producedBean;
//
//  @GET
//  public TemplateInstance basic() {
//    logger.info("The logger got produced");
//    logger.info("ProducedBean value: " + producedBean.getValue() + " ProducedBean: " + producedBean);
//
//    return producers.
//        data("myProducedString", myProducedString).
//        data("producedBeanValue", producedBean.getValue()).
//        data("producedBeanClass", producedBean);
//  }
}
