package si.bintegra.sp.application;


import com.liferay.portal.remote.cors.annotation.CORS;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.ConsultantRequest;
import si.bintegra.sp.service.ConsultantLocalServiceUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/consultant")
@Produces("application/json")
@Consumes("application/json")
@CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
public class ConsultatlController extends Application {

    @POST
    public void addConsultant(@RequestBody ConsultantRequest req) {
        if (req.getUserId() == null) {
            return;
        }

        ConsultantLocalServiceUtil.addConsultant(req.getUserId());
    }
}
