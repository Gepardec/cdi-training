package at.gepardec.training.cdi.advanced.customscope;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
@Path("/advanced/customscope")
public class CustomscopeController {

    private static final int ITERATION_COUNT_WITHIN_SCOPE = 3;

    @Inject
    private Models models;

    @Inject
    private WithExecutionScopeService service;

    @Controller
    @GET
    @Path("/")
    public String get(){
        models.put("data", buildModelData());
        return "advanced/customscope.xhtml";
    }

    private Map<String, List<String>> buildModelData() {
        Map<String, List<String>> idsPerExecution = new LinkedHashMap<>();

        idsPerExecution.put("Execution 1", service.executeWithinScope(ITERATION_COUNT_WITHIN_SCOPE));
        idsPerExecution.put("Execution 2", service.executeWithinScope(ITERATION_COUNT_WITHIN_SCOPE));

        return idsPerExecution;
    }
}
