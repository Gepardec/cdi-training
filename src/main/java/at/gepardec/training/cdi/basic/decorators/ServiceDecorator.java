package at.gepardec.training.cdi.basic.decorators;

import org.slf4j.Logger;

import javax.decorator.Delegate;
import javax.inject.Inject;

public abstract class ServiceDecorator implements ServiceApi {

    @Inject
    private Logger log;

    @Inject
    @Delegate
    private ServiceApi delegate;

    @Override
    public void doSomething() {
        log.info("decorated before. id=" + this.hashCode());
        delegate.doSomething();
        log.info("decorated after. id=" + this.hashCode());
    }
}
