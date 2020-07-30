package at.gepardec.cditraining.scopes;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ScopeMixRequest {

  private int value = 0;

  public int getValue() {
    return ++value;
  }
}
