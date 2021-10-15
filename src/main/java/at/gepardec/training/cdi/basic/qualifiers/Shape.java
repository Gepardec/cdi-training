package at.gepardec.training.cdi.basic.qualifiers;

public abstract class Shape {

    public String toString() {
        return this.getClass().getName() + "@" + hashCode();
    }
}
