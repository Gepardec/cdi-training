package at.gepardec.training.cdi.advanced.customscope;

/**
 * This interface specifies the api for the execution-context controlling.
 */
public interface ExecutionContextController {
    /**
     * Activates the context
     */
    void activate();

    /**
     * Deactivates the context, which shall release all held instances
     */
    void deactivate();

}
