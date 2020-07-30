package at.gepardec.cditraining.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ScopeMixApplication {

  @Inject
  ScopeMixSession scopeMixSession;

  private int value = 0;

  public int getValue() {
    return ++value;
  }

  public ScopeMixSession getScopeMixSession() {
    return scopeMixSession;
  }
}
