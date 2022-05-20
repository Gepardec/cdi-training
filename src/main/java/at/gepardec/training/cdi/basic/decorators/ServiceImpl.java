package at.gepardec.training.cdi.basic.decorators;

import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class ServiceImpl implements ServiceApi {

    @Inject
    private Logger log;

    @Override
    public void decorated() {
        log.info("decorated. id=" + this.hashCode());
    }

    @Override
    public void nonDecorated() {
        log.info("nonDecorated. id=" + this.hashCode());
    }
}
