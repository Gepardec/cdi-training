package at.gepardec.cditraining.uc.dynamicdefault;

import at.gepardec.cditraining.Util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@ServiceBQualifier
public class ServiceB implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
