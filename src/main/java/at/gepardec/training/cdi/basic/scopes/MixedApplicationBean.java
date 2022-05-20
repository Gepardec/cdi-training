package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.io.Serializable;

@Dependent
public class MixedApplicationBean implements Serializable {

    @Inject
    private MixedSessionBean mixedSessionBean;

    private int value = 0;

    public int incrementAndGet() {
        return ++value;
    }

    public MixedSessionBean scopeMixSession() {
        return mixedSessionBean;
    }
}
