package at.gepardec.training.cdi.advanced.lookupfactory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The scope is important because of the @Dependent scoped beans we have to manage.
 * This bean lives as long as the owning bean, so take care its in the proper scope.
 */
@Dependent
public class ServiceFactory {

    @Inject
    private BeanManager beanManager;

    @Inject
    @Any // Actually we select [@Any @TypedService] but it would be [@Default @TypedService] without @Any
    private Instance<Service> serviceInstances;

    private final List<Service> dependentServiceInstances = new LinkedList<>();

    /**
     * Here we cleanup the dependent scoped beans to avoid a memory leak.
     */
    @PreDestroy
    void destroy() {
        dependentServiceInstances.forEach(serviceInstances::destroy);
    }

    /**
     * This is the factory method which resolves the bean and takes care about dependent instance handling
     */
    public Service forType(String type) {
        final TypedService.TypedServiceLiteral literal = new TypedService.TypedServiceLiteral(
                Objects.requireNonNull(type, "Type must be set")
        );
        final Service service = serviceInstances.select(literal).get();
        if (isDependentScoped(literal)) {
            dependentServiceInstances.add(service);
        }
        return service;
    }

    /**
     * Here we get the bean definition from the CDI container and check what the scope of the implementation class is.
     */
    private boolean isDependentScoped(TypedService literal) {
        final Set<Bean<?>> beans = beanManager.getBeans(Service.class, literal);
        if (beans.size() == 1) {
            return Dependent.class.isAssignableFrom(beans.iterator().next().getScope());
        } else if (!beans.isEmpty()) {
            throw new IllegalStateException("Found multiple beans for service class and annotation literal: " + literal.toString());
        } else {
            throw new IllegalArgumentException("No beans found for Service interface and annotation literal: " + literal.toString());
        }
    }
}
