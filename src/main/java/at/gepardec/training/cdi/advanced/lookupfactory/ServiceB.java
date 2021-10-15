package at.gepardec.training.cdi.advanced.lookupfactory;


import at.gepardec.training.cdi.Util;

import javax.enterprise.context.Dependent;

@Dependent
@TypedService("B")
public class ServiceB implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
