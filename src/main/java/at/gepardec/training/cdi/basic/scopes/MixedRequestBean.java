package at.gepardec.training.cdi.basic.scopes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

@ApplicationScoped
public class MixedRequestBean implements Serializable {

  private int value = 0;

  public int incrementAndGet() {
    return ++value;
  }
}
