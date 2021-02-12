package at.gepardec.cditraining.uc.specializes;

import javax.enterprise.context.RequestScoped;

/**
 * That is the implementation we specialize
 */
@RequestScoped
public class ServiceOriginal implements Service {

    @Override
    public String execute() {
        return toString();
    }
}
