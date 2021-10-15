package at.gepardec.training.cdi.advanced.alternatives;

/**
 * All additional implementations need to be marked with @Alternative and one of them can be activated in the beans.xml.
 */
public interface Service {

    String execute();
}
