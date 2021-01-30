package at.gepardec.cditraining.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SecondApplicationScopedBean {
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
