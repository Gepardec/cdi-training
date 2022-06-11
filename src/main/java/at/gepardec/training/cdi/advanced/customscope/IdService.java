package at.gepardec.training.cdi.advanced.customscope;

import jakarta.annotation.PostConstruct;

import java.util.UUID;

/**
 * The execution scoped id service which generates a UUID on post-construct, where the id doesn't change within the execution-scope.
 */
@ExecutionScoped
public class IdService {

    private UUID id;

    @PostConstruct
    void init() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "IdService{" +
                "id=" + id +
                '}';
    }
}
