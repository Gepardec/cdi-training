package at.gepardec.training.cdi.basic.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class Producer {

    /**
     * This is a producer field.
     * If no scope is provided then the bean is produced for the @Dependent scope
     * If no qualifier is provided then the @Default is used
     */
    @Produces
    String producedString = "Hello, I got produced";

    /**
     * This is a producer method for a normal scoped bean.
     * We can define Parameters which are CDI beans and CDi will provide them for us.
     */
    @Produces
    @RequestScoped
    ProducedBean createProducedBean(Logger log) {
        log.info("Called BeanProducer#createProducedBean");
        return new ProducedBean();
    }
}
