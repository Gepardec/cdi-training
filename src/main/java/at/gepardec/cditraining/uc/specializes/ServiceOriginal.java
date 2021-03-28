package at.gepardec.cditraining.uc.specializes;

import at.gepardec.cditraining.Util;

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
