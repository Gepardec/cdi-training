package at.gepardec.training.cdi.basic.scopes;

import java.io.Serializable;

public class DependentBean implements Serializable {

    private int value = 0;

    public int incrementAndGet() {
        return ++value;
    }
}
