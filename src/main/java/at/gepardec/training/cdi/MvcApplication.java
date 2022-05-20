package at.gepardec.training.cdi;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath(MvcApplication.REST_APPLICATION_PATH)
public class MvcApplication extends Application {

    public static final String REST_APPLICATION_PATH = "/api";
}
