package at.gepardec.training.cdi.basic.scopes;

import jakarta.inject.Inject;

public class ApplicationBean {

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
