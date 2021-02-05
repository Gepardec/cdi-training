package at.gepardec.cditraining.qualifiers;

public abstract class Shape {

    public String toString() {
        return this.getClass().getName() + "@" + hashCode();
    }
}
