package at.gepardec.cditraining.interceptors;


import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@Inherited
@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BindingInterceptor {

    // Interceptor resolution considers the value of this attribute for resolving the interceptor implementation
    String type();
}
