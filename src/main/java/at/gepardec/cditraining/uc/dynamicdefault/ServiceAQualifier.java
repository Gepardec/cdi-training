package at.gepardec.cditraining.uc.dynamicdefault;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Inherited
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface ServiceAQualifier {
}
