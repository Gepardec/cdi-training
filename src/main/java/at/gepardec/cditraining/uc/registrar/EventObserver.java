package at.gepardec.cditraining.uc.registrar;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

/**
 * Just firing an event and forgetting it mostly not possible.
 * The registrar is the component which holds the result states and can be accessed by another
 * CDI bean to evaluate the failed/success states.
 */
@ApplicationScoped
public class EventObserver {

    @Inject
    private EventResultRegistrar eventResultRegistrar;

    void observe(@ObservesAsync EventData event) {
        if (event.fail) {
            eventResultRegistrar.registerFailedEvent(event.id);
        } else {
            try {
                Thread.sleep(3000);
                eventResultRegistrar.registerSuccessEvent(event.id);
            } catch (InterruptedException e) {
                eventResultRegistrar.registerFailedEvent(event.id);
            }
        }
    }
}
