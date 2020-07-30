package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ApplicationScopedBean {
  private int value = 0;

  public int getValue(){
    value++;
    return value;
  }
}
