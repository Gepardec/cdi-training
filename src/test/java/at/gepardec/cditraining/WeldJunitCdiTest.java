package at.gepardec.cditraining;

import at.gepardec.cditraining.qualifiers.Circle;
import at.gepardec.cditraining.qualifiers.Shape;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.ExcludeBean;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.mvc.Models;

import static org.mockito.Mockito.mock;

/**
 * This is a simple weld-junit5 test which spins up a CDI container for each test method.
 * The test class itself is a CDI bean as well, otherwise injections won't work.
 */
// Activates the necessary extensions
@ExtendWith({MockitoExtension.class, WeldJunit5AutoExtension.class})
// Adds all classes of this and its subpackages to the CDI container.
@AddPackages(Circle.class)
public class WeldJunitCdiTest {

    // We use Jakarta MVC but no MVC implementation available during the test, so we mock it.
    @Produces // Just an ordinary CDI Producer Field
    @ExcludeBean // Removes the original bean definition
    private Models models = mock(Models.class);

    @Inject
    @Any
    private Shape shape;

    @Test
    void test() {
        Assertions.assertNotNull(shape);
    }

    @Test
    void test2() {
        Assertions.assertNotNull(shape);
    }
}
