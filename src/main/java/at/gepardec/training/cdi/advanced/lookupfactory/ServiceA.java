package at.gepardec.training.cdi.advanced.lookupfactory;

import at.gepardec.training.cdi.Util;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@TypedService("A")
public class ServiceA implements Service {
    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
