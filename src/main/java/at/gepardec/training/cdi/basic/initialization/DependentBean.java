package at.gepardec.training.cdi.basic.initialization;

import jakarta.enterprise.context.Dependent;

/**
 * Not a normal scoped bean, but callbacks are still invoked.
 * Call logInit(); for initialization
 * Call logDestroy(); for destruction
 */
@Dependent
public class DependentBean extends BaseBean {

}
