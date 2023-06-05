package si.bintegra.sp.application;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        Object accesControlSet = containerResponseContext.getHeaders().get("Access-Control-Allow-Origin");
        if (accesControlSet == null) {
            containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", containerRequestContext.getHeaders().get("Origin").get(0));
        }
    }
}
