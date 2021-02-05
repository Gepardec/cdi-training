package at.gepardec.cditraining.scopes;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class MixedRequestBean implements Serializable {

  private int value = 0;

  public int incrementAndGet() {
    return ++value;
  }
}
