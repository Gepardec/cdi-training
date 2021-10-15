package at.gepardec.training.cdi.basic.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;

@RequestScoped
public class InjectModel {

    @Inject
    private Models models;

    public void setForView(String name) {
        models.put("name", "Congratulations '" + name + "', your fix works");
    }
}
