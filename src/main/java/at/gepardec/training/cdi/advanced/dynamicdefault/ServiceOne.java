package at.gepardec.training.cdi.advanced.dynamicdefault;

import at.gepardec.training.cdi.Util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@ServiceOneQualifier
public class ServiceOne implements Service {
    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
