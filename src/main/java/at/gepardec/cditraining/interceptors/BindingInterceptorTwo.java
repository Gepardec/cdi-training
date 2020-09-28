package at.gepardec.cditraining.interceptors;

import org.slf4j.Logger;
import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@BindingInterceptor(type = "TWO")
@Priority(Interceptor.Priority.APPLICATION)
public class BindingInterceptorTwo {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        logger.info("BindingInterceptorTwo start");
        Object proceed = ic.proceed();
        logger.info("BindingInterceptorTwo end");

        return proceed;
    }
}
