package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The annotation activates the CDI Interceptor which handles the context activation/deactivation.
 */
@WithExecutionScope
@RequestScoped
public class WithExecutionScopeService {

    /**
     * All code within this method is executed within the context and all CDI beans accessed here are the same instance for the current
     * invocation and will be new instances on another invocation within the same request.
     */
    public List<String> executeWithinScope(int count) {
        // In a loop retrieve the CDI Bean multiple times to see, that it is always the same one within this method
        return IntStream.range(0, count).mapToObj(i -> CDI.current().select(IdService.class).get().toString()).collect(Collectors.toList());
    }
}
