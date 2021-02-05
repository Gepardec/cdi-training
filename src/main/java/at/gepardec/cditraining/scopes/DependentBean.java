package at.gepardec.cditraining.scopes;

import java.io.Serializable;

public class DependentBean implements Serializable {

    int value = 0;

    public int incrementAndGet() {
        return ++value;
    }
}
