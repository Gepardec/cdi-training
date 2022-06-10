package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;

public class ExecutionScopedInstance<T> {

    private final T instance;

    private final CreationalContext<T> creationalContext;

    private final Contextual<T> contextual;

    public ExecutionScopedInstance(T instance, CreationalContext<T> creationalContext, Contextual<T> contextual) {
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
