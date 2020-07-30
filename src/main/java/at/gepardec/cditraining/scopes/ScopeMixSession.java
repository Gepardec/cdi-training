package at.gepardec.cditraining.scopes;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class ScopeMixSession implements Serializable {

  @Inject
  ScopeMixRequest scopeMixRequest;

  private int value = 0;

  public ScopeMixRequest getScopeMixRequest() {
    return scopeMixRequest;
  }

  public int getValue() {
    return ++value;
  }
}



