package at.gepardec.training.cdi.basic.initialization;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SessionBean extends BaseBean {

    @PostConstruct
    void init() {
        logInit();
    }

    @PreDestroy
    void destroy() {
        logDestroy();
    }
}
