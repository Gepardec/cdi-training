package at.gepardec.cditraining.decorators;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ServiceImpl implements ServiceApi {

    @Inject
    private Logger log;

    @Override
    public void doSomething() {
        log.info("doing something. id=" + this.hashCode());
    }

    @Override
    public void doSomethingElse() {
        log.info("doing something else. id=" + this.hashCode());
    }
}
