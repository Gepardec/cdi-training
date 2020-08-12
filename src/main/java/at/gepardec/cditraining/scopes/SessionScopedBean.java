package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class SessionScopedBean implements Serializable {
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
