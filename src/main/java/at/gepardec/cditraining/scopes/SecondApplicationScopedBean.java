package at.gepardec.cditraining.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SecondApplicationScopedBean {
  private int value = 0;

  public int getValue(){
    return ++value;
  }

  // For a later example
  @Inject
  DependentBean dependentBean;

  public DependentBean getDependentBean() {
    return dependentBean;
  }
}
