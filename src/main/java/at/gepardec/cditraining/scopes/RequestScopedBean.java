package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RequestScopedBean {

    // For a later example
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
