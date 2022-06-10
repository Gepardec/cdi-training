package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestScoped
@Path("/advanced/customscope")
public class CustomscopeController {

    @Inject
    private Models models;

    @Inject
    private ExecutionContextController activator;

//    @Controller
    @GET
    @Path("/")
    public String get(){
        models.put("data", execute());
        return "advanced/customscope.xhtml";
    }

    private Map<String, List<String>> execute() {
        Map<String, List<String>> idsPerExecution = new LinkedHashMap<>();

        idsPerExecution.put("Execution 1", executeSingle());
        idsPerExecution.put("Execution 2", executeSingle());
        idsPerExecution.put("Execution 3", executeSingle());
        idsPerExecution.put("Execution 4", executeSingle());

        return idsPerExecution;
    }

    private List<String> executeSingle() {
        try {
            activator.activate();
            return IntStream.range(0, 5).mapToObj(i -> CDI.current().select(IdService.class).get().toString()).collect(Collectors.toList());
        } finally {
            activator.deactivate();
        }
    }
}
