package com.example.csv.api.filters;

import io.vertx.core.json.JsonObject;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
@Priority(100)
public class ResponseFilter implements ContainerResponseFilter {

    @Inject
    Logger log;


    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        JsonObject response = new JsonObject();
        response.put("statusCode", responseContext.getStatus());
        response.put("statusType", responseContext.getStatusInfo());
        response.put("headers", responseContext.getStringHeaders());
        JsonObject responseData = new JsonObject();
        responseData.put("RESPONSE", response);
        log.info(responseData);
    }

}
