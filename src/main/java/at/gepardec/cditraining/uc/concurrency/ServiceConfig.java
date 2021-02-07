package at.gepardec.cditraining.uc.concurrency;

import javax.enterprise.inject.Vetoed;

/**
 * When handling concurrency then keep things immutable wherever you can.
 * Immutable instance can rarely cause problems.
 */
@Vetoed // When vetoed then the actual CDI bean is the producer method
//@RequestScoped // Uncomment to try what happens if this bean is pure request scoped, don't forget to remove the producer method!!
public class ServiceConfig {

    private final int counter;

    public ServiceConfig() {
        this(0);
    }

    public ServiceConfig(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}
