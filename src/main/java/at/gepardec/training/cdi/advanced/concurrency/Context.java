package at.gepardec.training.cdi.advanced.concurrency;

import jakarta.enterprise.inject.Vetoed;

/**
 * When handling concurrency then keep things immutable wherever you can.
 * Immutable instance cannot cause race conditions, because their state cannot be modified.
 */
@Vetoed // When vetoed, then the actual CDI bean is the producer method
//@RequestScoped // Uncomment to try what happens if this bean is pure request scoped, don't forget to remove the producer method!!
public class Context {

    private final String requestUri;

    public Context(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestUri() {
        return requestUri;
    }
}
