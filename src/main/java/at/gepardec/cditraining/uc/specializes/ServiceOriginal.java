package at.gepardec.cditraining.uc.specializes;

import javax.enterprise.context.RequestScoped;

/**
 * That is the default implementation is no alternative is activated.
 * With alternative, this bean is still available in the CDI container!!
 */
@RequestScoped
public class ServiceOriginal implements Service {

    @Override
    public String execute() {
        return toString();
    }
}
