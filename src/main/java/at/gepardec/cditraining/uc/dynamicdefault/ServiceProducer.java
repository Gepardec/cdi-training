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
    @ServiceOneQualifier
    private Service serviceOne;

    /**
     * Here we get the B implementation
     */
    @Inject
    @ServiceTwoQualifier
    private Service serviceTwo;

    @Inject
    private Logger log;

    /**
     * Just for demonstration, the actual parameter should come from a configuration
     */
    private String implementationType = "ServiceTwo";

    /**
     * This is the @Default qualified Service bean implementation.
     */
    @Produces
    @RequestScoped
    @Default
    Service createService() {
        switch (implementationType) {
            case "ServiceOne":
                log.info("ServiceOne is now default");
                return serviceOne;
            case "ServiceTwo":
                log.info("ServiceTwo is now default");
                return serviceTwo;
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
