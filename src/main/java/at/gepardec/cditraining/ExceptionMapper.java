package at.gepardec.cditraining;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.eclipse.krazo.engine.Viewable;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Models model;

    @Override
    public Response toResponse(Throwable exception) {
        final Viewable view = new Viewable("error.html");
        final Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;

        model.put("status", status.getStatusCode() + " (" + status.toString() + ")");
        model.put("path", uriInfo.getAbsolutePath());
        model.put("exceptionName", exception.getClass().getName());
        model.put("exceptionMessage", StringUtils.defaultString(exception.getMessage(), " - "));
        model.put("stackTrace", ExceptionUtils.getStackTrace(exception));

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(view).build();
    }
}
