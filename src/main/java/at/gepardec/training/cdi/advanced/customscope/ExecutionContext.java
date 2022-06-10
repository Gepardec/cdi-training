package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.spi.AlterableContext;

/**
 * The custom execution-context interface defining all necessary context specific contracts.
 */
public interface ExecutionContext extends AlterableContext, ExecutionContextController {
}
