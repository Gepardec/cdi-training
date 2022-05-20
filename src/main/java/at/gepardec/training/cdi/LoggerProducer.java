package at.gepardec.training.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class LoggerProducer {

    /**
     * This is a producer method.
     * If no scope is provided then the bean is produced for the @Dependent scope
     * If no qualifier is provided then the @Default is used
     *
     * @param injectionPoint the injectionPoint only available for @Dependent scoped beans
     * @return the produced logger
     */
    @Produces
    @Dependent
    public Logger produceLogger(InjectionPoint injectionPoint) {
        // There are some cases when this can be null, for instance with EJBs
        if (injectionPoint.getBean() != null) {
            return LoggerFactory.getLogger(injectionPoint.getBean().getBeanClass());
        }
        // Should not be null, but we want to be safe
        else if (injectionPoint.getMember() != null) {
            return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        }
        // In case we cannot determine declaring class
        else {
            return LoggerFactory.getLogger("default");
        }
    }

}
