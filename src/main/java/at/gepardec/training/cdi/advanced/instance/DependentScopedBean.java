package at.gepardec.training.cdi.advanced.instance;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;

@Dependent
public class DependentScopedBean {

    private byte[] data;

    @PostConstruct
    public void init(){
        data = new byte[2048];
    }

    @PreDestroy
    public void cleanup(){
        data = null;
    }
}
