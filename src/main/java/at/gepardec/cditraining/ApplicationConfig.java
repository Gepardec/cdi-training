package at.gepardec.cditraining;

import javax.enterprise.context.Dependent;

@Dependent
public class ApplicationConfig {

    public static final String REST_APPLICATION_PATH = "/api";

    public String getRestApplicationPath() {
        return REST_APPLICATION_PATH;
    }
}
