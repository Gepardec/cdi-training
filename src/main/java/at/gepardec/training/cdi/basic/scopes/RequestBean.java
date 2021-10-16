package at.gepardec.training.cdi.basic.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RequestBean {

    @Inject
    private DependentBean dependentBean;

    private int value = 0;

    public int incrementAndGet() {
        return ++value;
    }

    public DependentBean dependentBean() {
        return dependentBean;
    }
}
