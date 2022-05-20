package at.gepardec.training.cdi.advanced.alternatives;

import at.gepardec.training.cdi.Util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Alternative;

/**
 * This bean is the alternative implementation which is not enabled unless added to the beans.xml.
 */
@RequestScoped
@Alternative
public class ServiceDev implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
