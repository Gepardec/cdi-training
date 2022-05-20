package at.gepardec.training.cdi.advanced.lookupfactory;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;
import java.lang.annotation.*;

/**
 * All implementation classes are qualified with this qualifier.
 * The distinction is declared via the bind attribute.
 */
@Inherited
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface TypedService {

    /**
     * A annotation literal for this annotation which is used for the bean selection.
     */
    class TypedServiceLiteral extends AnnotationLiteral<TypedService> implements TypedService {

        private String type;

        public TypedServiceLiteral(String type) {
            this.type = type;
        }

        @Override
        public String value() {
            return type;
        }
    }

    /**
     * This is the binding attribute which selects the qualified implementation
     */
    String value();
}
