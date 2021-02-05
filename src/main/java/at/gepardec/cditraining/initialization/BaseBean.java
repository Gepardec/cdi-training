package at.gepardec.cditraining.initialization;

import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.Serializable;

public abstract class BaseBean implements Serializable {

    @Inject
    private Logger log;

    public void logInit() {
        log.info(this.getClass().getSimpleName() + " got initialized");
    }

    public void logDestroy() {
        log.info(this.getClass().getSimpleName() + " got destroyed");
    }
}
