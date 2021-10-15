package at.gepardec.training.cdi.basic.events;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

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
