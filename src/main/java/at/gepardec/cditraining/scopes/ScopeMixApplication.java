package at.gepardec.cditraining.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ScopeMixApplication {

  @Inject
  private ScopeMixSession scopeMixSession;

  private int value = 0;

  public int incrementAndGet() {
    return ++value;
  }

  public ScopeMixSession scopeMixSession() {
    return scopeMixSession;
  }
}
