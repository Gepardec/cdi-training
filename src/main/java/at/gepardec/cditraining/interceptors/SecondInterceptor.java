package at.gepardec.cditraining.interceptors;

import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SecondIntercept
@Priority(Interceptor.Priority.APPLICATION)
public class SecondInterceptor {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        logger.info("SecondInterceptor start");
        final Object result = ic.proceed();
        logger.info("SecondInterceptor end");
        return result;
    }
}