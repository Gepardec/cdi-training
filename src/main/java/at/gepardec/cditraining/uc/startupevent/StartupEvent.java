package at.gepardec.cditraining.uc.startupevent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Just a simple java type for the startup event
 */
public class StartupEvent {

    private final Set<String> observerIds = new HashSet<>();

    void add(String id) {
        Optional.ofNullable(id).ifPresent(observerIds::add);
    }

    Set<String> observerIds() {
        return Collections.unmodifiableSet(observerIds);
    }
}
