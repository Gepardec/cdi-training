package at.gepardec.training.cdi.advanced.customscope;

import jakarta.annotation.PostConstruct;

import java.util.UUID;

@ExecutionScoped
public class IdService {

    private UUID id;

    @PostConstruct
    void init(){
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
