package at.gepardec.cditraining.uc.lookupfactory;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@TypedService("A")
public class ServiceA implements Service {
    @Override
    public String execute() {
        return toString();
    }
}
