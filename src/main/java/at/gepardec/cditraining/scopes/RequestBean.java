package at.gepardec.cditraining.scopes;

import javax.inject.Inject;

public class RequestBean {

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
