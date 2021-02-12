package at.gepardec.cditraining.uc.concurrency;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

/**
 * This bean holds the state within the request scope, so that the here managed {@link ServiceConfig}
 * bean doesn't need to be annotated with @RequestScoped
 */
@RequestScoped
public class ServiceConfigProducer {

    private ServiceConfig serviceConfig;

    /**
     * When this method is called, then we are within an active request scope.
     * We create the immutable instance once, so now it's itself request scoped
     */
    @PostConstruct
    void init() {
        serviceConfig = new ServiceConfig(666);
    }

    /**
     * This producer method is called for any bean which needs an injection within this active request.
     * This producer is the actual CDI bean, therefore we had to put @Vetoed on actual bean class
     */
    @Produces
    @Dependent
    ServiceConfig createServiceConfig() {
        // We do nothing more but sharing the objects reference whereby the object is request scoped,
        // because it's a state of a request scoped CDI bean.
        return serviceConfig;
    }
}
