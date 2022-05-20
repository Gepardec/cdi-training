package at.gepardec.training.cdi.advanced.instance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequestScoped
@Path("/advanced/instance")
public class InstanceController {

    @Inject
    private Models models;

    @Inject
    private Instance<BeanInterfaceChild> beanInterfaceChildrenInstance;

    @Inject
    private Instance<BeanInterfaceRoot> beanInterfaceRootInstance;

    @Inject
    private Instance<BeanParent> beanParentInstance;

    @Controller
    @GET
    public String get() {
        final Map<String, List<String>> data = new LinkedHashMap<>();
        fillInForTypeAndInstance(data, BeanInterfaceRoot.class, beanInterfaceRootInstance);
        fillInForTypeAndInstance(data, BeanInterfaceChild.class, beanInterfaceChildrenInstance);
        fillInForTypeAndInstance(data, BeanParent.class, beanParentInstance);
        models.put("data", data);
        return "advanced/instances.xhtml";
    }

    private <T extends BeanInterfaceRoot> void fillInForTypeAndInstance(Map<String, List<String>> data, final Class<T> clazz, final Instance<T> instance) {
        final List<String> names = new LinkedList<>();
        instance.stream().forEach(bean -> names.add(bean.getName()));
        data.put("Instance<" + clazz.getSimpleName() + ">", names);
    }
}
