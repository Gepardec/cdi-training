package at.gepardec.training.cdi.advanced.customscope;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@WithExecutionScope
public class WithExecutionScopeInterceptor {

    @Inject
    private ExecutionContextController executionContextController;

    @AroundInvoke
    public Object invoke(final InvocationContext ctx) throws Exception {
        try {
            executionContextController.activate();
            return ctx.proceed();
        } finally {
            executionContextController.deactivate();
        }
    }
}
