package at.gepardec.cditraining.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SecondIntercept
public class SecondInterceptor extends BaseInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        return logAndProceed(ic);
    }
}
