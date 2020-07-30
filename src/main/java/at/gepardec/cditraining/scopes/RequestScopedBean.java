package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBean {
  private int value = 0;

  public int getValue(){
    value++;
    return value;
  }
}
