package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class ApplicationScopedBean {
  private int value = 0;

  public int getValue(){
    value++;
    return value;
  }

  // For a later example
  @Inject
  DependentBean dependentBean;

  public DependentBean getDependentBean() {
    return dependentBean;
  }
}
