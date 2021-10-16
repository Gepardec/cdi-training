package at.gepardec.training.cdi.basic.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@ApplicationScoped
public class MixedRequestBean implements Serializable {

  private int value = 0;

  public int incrementAndGet() {
    return ++value;
  }
}
