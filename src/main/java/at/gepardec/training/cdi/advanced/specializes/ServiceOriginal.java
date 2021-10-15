package at.gepardec.training.cdi.advanced.specializes;

import at.gepardec.training.cdi.Util;

import javax.enterprise.context.RequestScoped;

/**
 * That is the implementation we specialize
 */
@RequestScoped
public class ServiceOriginal implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
