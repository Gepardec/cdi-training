package at.gepardec.cditraining.uc.startupevent;

import org.slf4j.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * When the servlet container is up then CDI is up as well
 */
@WebListener("Startup listener to notify parts of the application that the application has been started")
public class StartupWebListener implements ServletContextListener {

    @Inject
    private Logger log;

    @Inject
    private Event<StartupEvent> startupEvent;

    /**
     * Fire a simple CDI event type to notify parts of the application that the application has started.
     * There is a WELD specific event (if you are using WELD) but this is the native approach
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Creating the event
        final StartupEvent event = new StartupEvent();
        log.info("Notifying Observers about startup");
        // Firing the event
        startupEvent.fire(event);
        // Log the observers who have observed this event
        log.info("Notified Observers: " + String.join(", ", event.observerIds()));
    }
}
