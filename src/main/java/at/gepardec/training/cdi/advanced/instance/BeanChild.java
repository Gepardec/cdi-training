package at.gepardec.training.cdi.advanced.instance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;

@Default
@RequestScoped
public class BeanChild implements BeanInterfaceChild {
}
