package at.gepardec.cditraining.uc.alternatives;

import at.gepardec.cditraining.Util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

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
