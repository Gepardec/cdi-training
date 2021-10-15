package at.gepardec.training.cdi.basic.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * The qualifier for the rectangle implementation
 */
// Inherited necessary because of proxying
@Inherited
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface RectangleShape {
}
