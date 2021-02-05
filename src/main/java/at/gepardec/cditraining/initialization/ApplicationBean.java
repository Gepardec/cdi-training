package at.gepardec.cditraining.initialization;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ApplicationBean extends BaseBean {

    @PostConstruct
    void init() {
        logInit();
    }

    @PreDestroy
    void destroy() {
        logDestroy();
    }
}
