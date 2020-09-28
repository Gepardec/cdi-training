package at.gepardec.cditraining.interceptors;

import org.slf4j.Logger;
import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@BindingInterceptor(type = "ONE")
@Priority(Interceptor.Priority.APPLICATION)
public class BindingInterceptorOne {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        logger.info("BindingInterceptorOne start");
        Object proceed = ic.proceed();
        logger.info("BindingInterceptorOne end");

        return proceed;
    }
}
