package at.gepardec.training.cdi.advanced.registrar;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

/**
 * Just firing an event and forgetting it mostly not possible.
 * The registrar is the component which holds the results and can be accessed by other
 * CDI beans to evaluate the captured results.
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
