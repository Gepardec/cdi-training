package at.gepardec.cditraining.qualifiers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@Alternative
public class Rectangle extends Shape {}
