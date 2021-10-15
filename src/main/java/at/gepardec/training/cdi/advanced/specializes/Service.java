package at.gepardec.training.cdi.advanced.specializes;

/**
 * With specialization we don't implement this interface directly, but via the specialized bean we will inherit from
 */
public interface Service {

    String execute();
}
