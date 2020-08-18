package at.gepardec.cditraining.interceptors;

import org.slf4j.Logger;
import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SecondIntercept
@Priority(Interceptor.Priority.APPLICATION + 2)
public class SecondInterceptor {

  @Inject Logger logger;

  @AroundInvoke
  public Object intercept(InvocationContext ic) throws Exception {
    logger.info("I got intercepted: " + ic.getTarget() + " in method " + ic.getMethod().getName());
    logger.info(MDC.get("first"));
    return ic.proceed();
  }
}
