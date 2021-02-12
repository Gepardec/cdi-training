package at.gepardec.cditraining.uc.registrar;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This registrar holds the state of event executions and is accessed concurrently.
 * Because of the concurrent access we need to ensure proper synchronization.
 */
@ApplicationScoped
public class EventResultRegistrar {

    private final Set<String> successEvents = Collections.synchronizedSet(new HashSet<>());

    private final Set<String> failedEvents = Collections.synchronizedSet(new HashSet<>());

    void registerSuccessEvent(String id) {
        successEvents.add(id);
    }

    void registerFailedEvent(String id) {
        failedEvents.add(id);
    }

    // Ensure that during the copy of the list nobody accesses this bean
    synchronized void clear() {
        failedEvents.clear();
        successEvents.clear();
    }

    synchronized Set<String> successEvents() {
        return new HashSet<>(successEvents);
    }

    synchronized Set<String> failedEvents() {
        return new HashSet<>(failedEvents);
    }
}
