package at.gepardec.cditraining.uc.alternatives;

import javax.enterprise.context.RequestScoped;

/**
 * That is the default implementation is no alternative is activated.
 * With alternative, this bean is still available in the CDI container!!
 */
@RequestScoped
public class ServiceProd implements Service {

    @Override
    public String execute() {
        return toString();
    }
}
