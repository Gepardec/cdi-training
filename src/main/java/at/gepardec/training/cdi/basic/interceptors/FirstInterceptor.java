package at.gepardec.training.cdi.basic.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@FirstIntercept
public class FirstInterceptor extends BaseInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        return logAndProceed(ic);
    }
}
