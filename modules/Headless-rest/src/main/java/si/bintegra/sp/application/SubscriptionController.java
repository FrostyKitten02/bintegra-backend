package si.bintegra.sp.application;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.SubscriptionRequestDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;

@Component(
        properties = "subscriptionController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/subscription")
@Produces("application/json")
@Consumes("application/json")
public class SubscriptionController extends Application {

    @POST
    @Path("/subscribe")
    public void subscribe(@RequestBody SubscriptionRequestDto req) {
        //TODO add logic!!!
    }

}
