package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class MixedSessionBean implements Serializable {

    @Inject
    private MixedRequestBean mixedRequestBean;

    private int value = 0;

    public MixedRequestBean scopeMixRequest() {
        return mixedRequestBean;
    }

    public int incrementAndGet() {
        return ++value;
    }
}



