package at.gepardec.training.cdi.advanced.instance;

import jakarta.enterprise.context.RequestScoped;

@Second
@RequestScoped
public class SecondBeanChild implements BeanInterfaceChild {
}
