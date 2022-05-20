package at.gepardec.training.cdi.advanced.instance;

public interface BeanInterfaceRoot {

    default String getName() {
        return this.getClass().getSimpleName() + " implements " + BeanInterfaceRoot.class.getSimpleName();
    }
}
