package at.gepardec.training.cdi.advanced.dynamicdefault;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Inherited
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface ServiceTwoQualifier {
}
