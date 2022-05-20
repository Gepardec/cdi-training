package at.gepardec.training.cdi.advanced.startupevent;

import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@Dependent
public class StartupObserver {

    @Inject
    private Logger log;

    void observeStartup(@Observes StartupEvent event) {
        event.add(getClass().getSimpleName());
        log.info("Startup observed by " + getClass().getSimpleName());
    }
}
