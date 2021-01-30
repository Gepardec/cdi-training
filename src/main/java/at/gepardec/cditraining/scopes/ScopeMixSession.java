package at.gepardec.cditraining.scopes;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class ScopeMixSession implements Serializable {

  @Inject
  private ScopeMixRequest scopeMixRequest;

  private int value = 0;

  public ScopeMixRequest scopeMixRequest() {
    return scopeMixRequest;
  }

  public int incrementAndGet() {
    return ++value;
  }
}



