package at.gepardec.training.cdi.basic.qualifiers;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative //Why do you think this is necessary?
public class Rectangle extends Shape {

}
