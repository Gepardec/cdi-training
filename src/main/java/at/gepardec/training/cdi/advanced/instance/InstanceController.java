package at.gepardec.training.cdi.advanced.instance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RequestScoped
@Path("/advanced/instance")
public class InstanceController {

    @Inject
    private Models models;

    @Inject
    private Instance<BeanInterfaceChild> beanInterfaceChildrenInstanceDefault;

    @Inject
    @Any
    private Instance<BeanInterfaceChild> beanInterfaceChildrenInstanceAny;

    @Inject
    @Second
    private Instance<BeanInterfaceChild> beanInterfaceChildrenInstanceSecond;

    @Inject
    @Any
    private Instance<BeanInterfaceRoot> beanInterfaceRootInstance;

    @Inject
    @Any
    private Instance<BeanParent> beanParentInstance;

    @Controller
    @GET
    public String get() {
        final Map<String, List<String>> data = new LinkedHashMap<>();
        fillInForTypeAndInstance(data, "@Inject @Any", BeanInterfaceRoot.class, beanInterfaceRootInstance);
        fillInForTypeAndInstance(data, "@Inject @Any", BeanParent.class, beanParentInstance);
        fillInForTypeAndInstance(data, "@Inject", BeanInterfaceChild.class, beanInterfaceChildrenInstanceDefault);
        fillInForTypeAndInstance(data, "@Inject @Any", BeanInterfaceChild.class, beanInterfaceChildrenInstanceAny);
        fillInForTypeAndInstance(data, "@Inject @Second", BeanInterfaceChild.class, beanInterfaceChildrenInstanceSecond);
        fillInProgrammaticLookup(data);
        models.put("data", data);
        return "advanced/instances.xhtml";
    }

    private void fillInProgrammaticLookup(Map<String, List<String>> data) {
        data.put("instance.select(new AnnotationLiteral<Default>(){})", List.of(beanInterfaceChildrenInstanceAny.select(new AnnotationLiteral<Default>() {
        }).get().getName()));
        data.put("instance.select(new SecondLiteral())", List.of(beanInterfaceChildrenInstanceAny.select(new SecondLiteral()).get().getName()));
    }

    private <T extends BeanInterfaceRoot> void fillInForTypeAndInstance(Map<String, List<String>> data, final String annotations, final Class<T> clazz, final Instance<T> instance) {
        final List<String> names = new LinkedList<>();
        instance.stream().forEach(bean -> names.add(bean.getName()));
        data.put(annotations + " Instance<" + clazz.getSimpleName() + ">", names);
    }
}
