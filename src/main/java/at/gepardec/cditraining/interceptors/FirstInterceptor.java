package at.gepardec.cditraining.interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@FirstIntercept
@Priority(Interceptor.Priority.APPLICATION)
public class FirstInterceptor extends BaseInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        return logAndProceed(ic);
    }
}
