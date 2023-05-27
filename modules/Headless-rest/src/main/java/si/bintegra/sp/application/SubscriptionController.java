package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.SubscriptionRequestDto;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.service.SubscriptionService;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        properties = "subscriptionController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/subscription")
@Produces("application/json")
@Consumes("application/json")
public class SubscriptionController extends Application {
    @Reference
    private SubscriptionService subscriptionService;

    @POST
    @Path("/subscribe")
    public void subscribe(@RequestBody SubscriptionRequestDto req, @Context HttpServletRequest request) throws PortalException {
        User user = PortalUtil.getUser(request);
        subscriptionService.addSubscription(req.getPackageOfferId(), user.getUserId(),req.getPhoneId());
    }

    @GET
    public List<SubscriptionDto> getSubscriptions(@Context HttpServletRequest request) throws PortalException {
        User user = PortalUtil.getUser(request);
        return subscriptionService.findSubscriptionsByUserId(user.getUserId()).stream().map(this::toDto).collect(Collectors.toList());
    }

    //TODO move to separate class and package
    private SubscriptionDto toDto(Subscription subscription) {
        SubscriptionDto dto = new SubscriptionDto();
        dto.setPackageOffer(subscription.getPackageOffer());
        return dto;
    }

}
