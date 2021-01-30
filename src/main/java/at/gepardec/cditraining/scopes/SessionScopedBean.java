package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class SessionScopedBean implements Serializable {

    // For a later example
    @Inject
    private DependentBean dependentBean;

    private int value = 0;

    public int incrementAndGet() {
        value++;
        return value;
    }


    public DependentBean dependentBean() {
        return dependentBean;
    }
}
