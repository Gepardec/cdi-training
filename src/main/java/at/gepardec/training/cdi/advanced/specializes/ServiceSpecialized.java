package at.gepardec.training.cdi.advanced.specializes;

import at.gepardec.training.cdi.Util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Specializes;

/**
 * This bean is a specialized implementation of a actual bean, so we need to inherit the bean we specialize.
 */
@RequestScoped
@Specializes
public class ServiceSpecialized extends ServiceOriginal {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
