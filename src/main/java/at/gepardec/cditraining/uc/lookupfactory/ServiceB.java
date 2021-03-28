package at.gepardec.cditraining.uc.lookupfactory;


import at.gepardec.cditraining.Util;

import javax.enterprise.context.Dependent;

@Dependent
@TypedService("B")
public class ServiceB implements Service {

    @Override
    public String execute() {
        return Util.nameWithInstanceId(this);
    }
}
