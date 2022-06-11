package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;

/**
 * This is the CDI extension registering our execution context.
 */
public class ExecutionContextExtension implements Extension {

    private static final ExecutionContext CONTEXT_SINGLETON = new ExecutionContextImpl();

    void registerexecutionContext(@Observes final AfterBeanDiscovery event, final BeanManager beanManager) {
        // Register the execution-context instance
        event.addContext(CONTEXT_SINGLETON);

        // Register via the configurator a CDI wrapper over the execution-context, for controlling the execution context activity.
        event.addBean()
                .scope(ApplicationScoped.class)
                .addQualifier(Default.Literal.INSTANCE)
                .addType(ExecutionContextController.class)
                .beanClass(ExecutionContextExtension.class)
                .createWith(ctx -> new ExecutionContextControllerImpl(CONTEXT_SINGLETON));
    }

}
