package at.gepardec.cditraining.producers;

import javax.enterprise.inject.Vetoed;
import java.io.Serializable;

/**
 * {@link Vetoed} is necessary because we use bean-discovery-mode 'all'
 */
@Vetoed
public class ProducedBean implements Serializable {
    private int value = 0;

    public int getValue() {
        return ++value;
    }
}
