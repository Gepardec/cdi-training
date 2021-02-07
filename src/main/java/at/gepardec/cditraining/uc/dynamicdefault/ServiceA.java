package at.gepardec.cditraining.uc.dynamicdefault;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@ServiceAQualifier
public class ServiceA implements Service {
    @Override
    public String execute() {
        return toString();
    }
}
