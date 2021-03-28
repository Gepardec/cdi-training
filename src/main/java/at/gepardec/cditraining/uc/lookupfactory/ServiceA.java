package at.gepardec.cditraining.uc.lookupfactory;

import at.gepardec.cditraining.Util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@TypedService("A")
public class ServiceA implements Service {
    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
