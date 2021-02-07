package at.gepardec.cditraining.uc.dynamicdefault;

/**
 * All implementations need to be qualified so that there is no default implementation but our producer method
 */
public interface Service {

    String execute();
}
