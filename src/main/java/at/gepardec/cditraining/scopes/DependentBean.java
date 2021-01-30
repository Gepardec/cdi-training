package at.gepardec.cditraining.scopes;

import javax.enterprise.context.Dependent;
import java.io.Serializable;

@Dependent
public class DependentBean implements Serializable {

    int value = 0;

    public int incrementAndGet() {
        return ++value;
    }
}
