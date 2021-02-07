package at.gepardec.cditraining.uc.dynamicdefault;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@ServiceBQualifier
public class ServiceB implements Service {

    @Override
    public String execute() {
        return toString();
    }
}
