package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;

import java.lang.annotation.Annotation;

/**
 * The CDI bean for controlling the CDI context
 */
public class ExecutionContextControllerDelegate implements ExecutionContextController {

    private final ExecutionContext delegate;

    public ExecutionContextControllerDelegate(ExecutionContext delegate) {
        this.delegate = delegate;
    }

    @Override
    public void activate() {
        if(!delegate.isActive()) {
            delegate.activate();
        }
    }

    @Override
    public void deactivate() {
        if(delegate.isActive()) {
            delegate.deactivate();
        }
    }
}
