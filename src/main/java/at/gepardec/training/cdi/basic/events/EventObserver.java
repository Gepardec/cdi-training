package at.gepardec.training.cdi.basic.events;

import org.slf4j.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.enterprise.event.Reception;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventObserver {

    @Inject
    Logger logger;

    /**
     * The method which observes a event of type String
     *
     * @param messageEvent the event this method observes
     * @throws Exception If the sleep fails
     */
    void observe(@ObservesAsync(notifyObserver = Reception.IF_EXISTS) String messageEvent) throws Exception {
        Thread.sleep(3000);
        logger.info("Message received. Message: '{}'", messageEvent);
    }
}
