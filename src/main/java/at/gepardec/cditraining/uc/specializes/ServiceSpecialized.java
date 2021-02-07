package at.gepardec.cditraining.uc.specializes;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;

/**
 * This bean is a specialized implementation of a actual bean, so we need to inherit the bean we specialize.
 */
@RequestScoped
@Specializes
public class ServiceSpecialized extends ServiceOriginal {

    @Override
    public String execute() {
        return toString();
    }
}
