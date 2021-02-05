package at.gepardec.cditraining.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public abstract class BaseBean implements Serializable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void logInit() {
        log.info(this.getClass().getSimpleName() + " got initialized");
    }

    public void logDestroy() {
        log.info(this.getClass().getSimpleName() + " got destroyed");
    }
}
