package at.gepardec.training.cdi.basic.qualifiers;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;

@Dependent
@Alternative //Why do you think this is necessary?
public class Rectangle extends Shape {

}
