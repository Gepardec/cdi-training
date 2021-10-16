package at.gepardec.training.cdi;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(MvcApplication.REST_APPLICATION_PATH)
public class MvcApplication extends Application {

    public static final String REST_APPLICATION_PATH = "/api";
}
