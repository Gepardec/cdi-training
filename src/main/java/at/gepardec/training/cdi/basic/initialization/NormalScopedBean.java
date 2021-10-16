package at.gepardec.training.cdi.basic.initialization;

import javax.enterprise.context.RequestScoped;

/**
 * Any scope but @Dependent is a normal scope.
 * Call logInit(); for initialization
 * Call logDestroy(); for destruction
 */
@RequestScoped
public class NormalScopedBean extends BaseBean {

}
