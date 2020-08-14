package at.gepardec.cditraining.producers;

import java.io.Serializable;

public class ProducedBean implements Serializable {
  private int value = 0;

  public int getValue() {
    return ++value;
  }
}
