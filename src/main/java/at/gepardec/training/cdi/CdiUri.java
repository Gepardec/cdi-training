package at.gepardec.training.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("cdiUri")
@ApplicationScoped
public class CdiUri {

    private static final String CDI_ORG_URI = "http://cdi-spec.org";

    private static final String SPEC_URI = "https://jakarta.ee/specifications/cdi/2.0/cdi-spec-2.0.html";

    private static final String JEE_TUTORIAL_INITIALIZATION = "https://javaee.github.io/tutorial/cdi-basic014.html";

    public String getCdiOrgUri() {
        return CDI_ORG_URI;
    }

    public String getSpecUri() {
        return SPEC_URI;
    }

    public String getJeeTutorialInitialization() {
        return JEE_TUTORIAL_INITIALIZATION;
    }
}
