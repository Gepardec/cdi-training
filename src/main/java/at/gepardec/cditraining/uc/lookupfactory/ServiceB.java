package at.gepardec.cditraining.uc.lookupfactory;


import javax.enterprise.context.Dependent;

@Dependent
@TypedService("B")
public class ServiceB implements Service {

    @Override
    public String execute() {
        return toString();
    }
}
