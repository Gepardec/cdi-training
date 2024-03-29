package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;

/**
 * This model holds the instance CDI related instances, so we can properly destroy the CDI bean wrapping the acual instance.
 * @param <T> the instance type
 */
public class ExecutionContextInstance<T> {

    private final T instance;

    private final CreationalContext<T> creationalContext;

    private final Contextual<T> contextual;

    public ExecutionContextInstance(T instance, CreationalContext<T> creationalContext, Contextual<T> contextual) {
        this.instance = instance;
        this.creationalContext = creationalContext;
        this.contextual = contextual;
    }

    public void destroy(){
        contextual.destroy(instance, creationalContext);
    }

    public T getInstance() {
        return instance;
    }
}
