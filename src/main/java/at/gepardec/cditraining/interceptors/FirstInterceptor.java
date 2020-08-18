package at.gepardec.cditraining.interceptors;

import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@FirstIntercept
@Priority(Interceptor.Priority.APPLICATION + 1)
public class FirstInterceptor {

  @AroundInvoke
  public Object intercept(InvocationContext ic) throws Exception {
    MDC.put("first", "Added by " + this.getClass().getSimpleName());
    Object proceed = ic.proceed();
    MDC.remove("first");
    return proceed;
  }
}
