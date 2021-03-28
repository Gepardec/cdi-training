package at.gepardec.cditraining.uc.dynamicdefault;

import at.gepardec.cditraining.Util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@ServiceAQualifier
public class ServiceA implements Service {
    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
