package com.example.csv.api.filters;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;


@Provider
@Priority(10)
public class RequestFilter implements ContainerRequestFilter {

    @Inject
    Logger log;

    @Context
    HttpServerRequest httpServerRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        JsonObject request = new JsonObject();
        request.put("absolutePath", requestContext.getUriInfo().getAbsolutePath());
        request.put("path", requestContext.getUriInfo().getPath());
        request.put("method", requestContext.getMethod());
        request.put("headers", requestContext.getHeaders());
        request.put("pathParams", requestContext.getUriInfo().getPathParameters());
        request.put("queryParams", requestContext.getUriInfo().getQueryParameters());
        request.put("address", httpServerRequest.remoteAddress().toString());
        JsonObject requestData = new JsonObject();
        requestData.put("REQUEST", request);
        log.info(requestData);
    }

}
