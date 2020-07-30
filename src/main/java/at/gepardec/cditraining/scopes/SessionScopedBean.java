package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class SessionScopedBean implements Serializable {
  private int value = 0;

  public int getValue(){
    value++;
    return value;
  }
}
