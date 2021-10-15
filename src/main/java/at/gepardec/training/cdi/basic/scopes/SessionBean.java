package at.gepardec.training.cdi.basic.scopes;

import javax.inject.Inject;
import java.io.Serializable;

public class SessionBean implements Serializable {

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
