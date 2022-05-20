package at.gepardec.training.cdi.basic.decorators;

import org.slf4j.Logger;

import jakarta.decorator.Delegate;
import jakarta.inject.Inject;

public abstract class ServiceDecorator implements ServiceApi {

    @Inject
    private Logger log;

    @Inject
    @Delegate
    private ServiceApi delegate;

    @Override
    public void decorated() {
        log.info("decorated before. id=" + this.hashCode());
        delegate.decorated();
        log.info("decorated after. id=" + this.hashCode());
    }
}
