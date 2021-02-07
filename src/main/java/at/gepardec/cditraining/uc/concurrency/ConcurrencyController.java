package at.gepardec.cditraining.uc.concurrency;

import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * This controller triggers the concurrent execution of the Service bean by a GET request.
 */
@Path("/uc/concurrency")
@RequestScoped
@Controller
public class ConcurrencyController {

    @Inject
    private Logger log;

    /**
     * When a GET request arrives here then the service bean and its dependencies are already injected and fully initialized.
     * Therefore we have no problem executing it on a different Thread.
     */
    @Inject
    private Service service;

    @Resource
    private ManagedExecutorService executorService;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() throws Exception {
        model.put("concurrentResult", executorService.submit(() -> service.execute()).get());
        model.put("controllerResult", "Executed on Thread: " + Thread.currentThread().getId());
        return "uc/concurrency/concurrency.html";
    }
}
