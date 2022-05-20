package at.gepardec.training.cdi.advanced.instance;

public interface BeanInterfaceChild extends BeanInterfaceRoot {

    default String getName() {
        return this.getClass().getSimpleName() + " implements " + BeanInterfaceChild.class.getSimpleName();
    }
}
