package at.gepardec.cditraining.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InitApplicationScopedBean {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @PostConstruct
  public void init(){
    log.info(this.getClass() + " got initialized");
  }

  @PreDestroy
  public void destroy(){
    log.info(this.getClass() + " got destroyed");
  }
}
