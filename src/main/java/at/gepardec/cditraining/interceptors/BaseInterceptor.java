package at.gepardec.cditraining.interceptors;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;

public abstract class BaseInterceptor {

    @Inject
    protected Logger logger;

    protected Object logAndProceed(final InvocationContext ic) throws Exception {
        String interceptedMethodInfo = ic.getTarget().getClass().getSuperclass().getSimpleName() + "." + ic.getMethod().getName() + "(...)";
        logger.info("start  -> " + interceptedMethodInfo);
        final Object result = ic.proceed();
        logger.info("end  -> " + interceptedMethodInfo);
        return result;
    }
}
