package at.gepardec.cditraining.qualifiers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@Alternative // Maybe this is not suitable here, you decide :)
public class Rectangle extends Shape {
}
