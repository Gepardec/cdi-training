package at.gepardec.training.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("cdiUri")
@ApplicationScoped
public class CdiUri {

    private static final String CDI_ORG_URI = "https://cdi-spec.org";

    private static final String SPEC_URI = "https://jakarta.ee/specifications/cdi/3.0/jakarta-cdi-spec-3.0.html";

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
