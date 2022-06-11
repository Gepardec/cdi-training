package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.NormalScope;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The custom scope which is a normal scope (proxyable).
 */
@NormalScope
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ExecutionScoped {
}
