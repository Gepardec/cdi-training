package at.gepardec.cditraining.uc.dynamicdefault;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * This producer is responsible for deciding what bean is returned for @Default annotated injection points.
 */
@ApplicationScoped
public class ServiceProducer {

    /**
     * Here we get the A implementation
     */
    @Inject
    @ServiceAQualifier
    private Service serviceA;

    /**
     * Here we get the B implementation
     */
    @Inject
    @ServiceBQualifier
    private Service serviceB;

    @Inject
    private Logger log;

    /**
     * Just for demonstration, the actual parameter should come from a configuration
     */
    private String implementationType = "ServiceB";

    /**
     * This is the @Default qualified Service bean implementation.
     */
    @Produces
    @RequestScoped
    @Default
    Service createService() {
        switch (implementationType) {
            case "ServiceA":
                log.info("ServiceA is now default");
                return serviceA;
            case "ServiceB":
                log.info("ServiceB is now default");
                return serviceB;
            default:
                throw new IllegalArgumentException("implementationType unknown. type: " + implementationType);
        }
    }

    String getImplementationType() {
        return implementationType;
    }

    void setImplementationType(String implementationType) {
        this.implementationType = implementationType;
    }
}
