package si.bintegra.sp.application;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.request.ConsultantRequest;
import si.bintegra.sp.service.ConsultantLocalServiceUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = ConsultantController.class
)
@Path("/consultant")
@Produces("application/json")
@Consumes("application/json")
public class ConsultantController extends Application {

    @POST
    public Object addConsultant(@RequestBody ConsultantRequest req) {
        if (req.getUserId() == null) {
            return new Object();
        }

        ConsultantLocalServiceUtil.addConsultant(req.getUserId());
        return new Object();
    }
}
