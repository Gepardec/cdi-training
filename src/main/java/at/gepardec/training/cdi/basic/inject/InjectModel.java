package at.gepardec.training.cdi.basic.inject;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Models;

@RequestScoped
public class InjectModel {

    @Inject
    private Models models;

    public void setForView(String name) {
        models.put("name", "Congratulations '" + name + "', your fix works");
    }
}
