package at.gepardec.training.cdi.advanced.dynamicdefault;

import at.gepardec.training.cdi.Util;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@ServiceTwoQualifier
public class ServiceTwo implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
