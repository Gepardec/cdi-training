package at.gepardec.cditraining.uc.startupevent;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Dependent
public class StartupObserver {

    @Inject
    private Logger log;

    void observeStartup(@Observes StartupEvent event) {
        event.add(getClass().getSimpleName());
        log.info("Startup observed by " + getClass().getSimpleName());
    }
}
