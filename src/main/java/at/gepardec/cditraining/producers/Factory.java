package at.gepardec.cditraining.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class Factory {

  @Produces
  String producedString = "Hello, I got produced";

  @Produces
  public Logger produceLogger(InjectionPoint injectionPoint){
    return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
  }

  @Produces
  ProducedBean producedBean = new ProducedBean();

}
