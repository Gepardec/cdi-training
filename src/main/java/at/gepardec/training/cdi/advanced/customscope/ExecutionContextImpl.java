package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.ContextNotActiveException;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.Vetoed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The execution-context implementation which handles the instance management.
 */
@Vetoed
public class ExecutionContextImpl implements ExecutionContext {

    private static final Logger LOG = LoggerFactory.getLogger(ExecutionContextImpl.class);

    /**
     * An execution-context is bound to the current Thread whereby ThreadLocal manages the bean instances.
     */
    private static ThreadLocal<Map<Contextual<?>, ExecutionContextInstance>> INSTANCES = new ThreadLocal<>();

    @Override
    public Class<? extends Annotation> getScope() {
        return ExecutionScoped.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        final var instancesOfThread = INSTANCES.get();
        if (instancesOfThread == null) {
            throw new ContextNotActiveException("No active context for current Thread");
        }
        ExecutionContextInstance<T> instance = instancesOfThread.get(contextual);
        if (instance == null && creationalContext != null) {
            instance = new ExecutionContextInstance(contextual.create(creationalContext), creationalContext, contextual);
            instancesOfThread.put(contextual, instance);
        }

        return (instance != null) ? instance.getInstance() : null;
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        return get(contextual, null);
    }

    @Override
    public boolean isActive() {
        return INSTANCES.get() != null;
    }

    @Override
    public void destroy(Contextual<?> contextual) {
        var instancesOfThread = INSTANCES.get();
        if (instancesOfThread != null) {
            var instance = instancesOfThread.get(contextual);
            if (instance != null) {
                try {
                    instance.destroy();
                } catch (Exception e) {
                    LOG.warn("Could not destroy the contextual instance. Error: " + e.getMessage());
                }
            }
        }
    }

    public void activate() {
        INSTANCES.set(Collections.synchronizedMap(new HashMap<>(50, 1)));
    }

    public void deactivate() {
        Optional.ofNullable(INSTANCES.get()).ifPresent(map -> map.keySet().forEach(this::destroy));
        INSTANCES.remove();
    }
}
