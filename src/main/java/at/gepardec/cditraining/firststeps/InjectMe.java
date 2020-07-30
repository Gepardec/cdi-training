package at.gepardec.cditraining.firststeps;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class InjectMe {

  @Inject
  @ResourcePath("firstinject/firstinject.html")
  Template firstinject;

  @Inject
  @ResourcePath("firstinject/constructorinject.html")
  Template constructorinject;

  public TemplateInstance firstinject() {
    return firstinject.data("name", "trainee");
  }

  public TemplateInstance constructorinject() {
    return constructorinject.instance();
  }
}
