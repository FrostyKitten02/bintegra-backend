package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.SubscriptionRequest;
import si.bintegra.sp.dto.SubscriptionResponse;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.service.ConsultantCustomerLocalServiceUtil;
import si.bintegra.sp.service.OfferLocalServiceUtil;
import si.bintegra.sp.service.SubscriptionLocalServiceUtil;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/subscription")
@Produces("application/json")
@Consumes("application/json")
public class SubscriptionController {
    private static final Log _log = LogFactoryUtil.getLog(SubscriptionController.class);

    @POST
    @Path("/subscribe")
    public SubscriptionResponse subscribe(@RequestBody SubscriptionRequest req, @Context HttpServletRequest request) throws PortalException {
        SubscriptionResponse res = new SubscriptionResponse();
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserGuestStrict(user);

        SubscriptionDto subDto = req.getSubscription();

        Subscription sub = SubscriptionLocalServiceUtil.addSubscription(subDto.getOfferId(), user.getUserId(),subDto.getPhoneId(), subDto.getStartDate(), subDto.getSubscriptionContract());
        ConsultantCustomerLocalServiceUtil.assignConsultantToCustomer(user.getUserId());

        res.setSubscriptionId(sub.getId());
        return res;
    }

    @GET
    public SubscriptionResponse getUserSubscriptions(@Context HttpServletRequest request) throws PortalException {
        SubscriptionResponse res = new SubscriptionResponse();
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserGuestStrict(user);

        List<SubscriptionDto> subs = SubscriptionLocalServiceUtil
                .findSubscriptionsByUserId(user.getUserId())
                .stream().map(subscription -> {
                    Long offerId = subscription.getOfferId();
                    Offer offer = null;
                    try {
                        offer = OfferLocalServiceUtil.findById(offerId);
                    } catch (NoSuchOfferException e) {
                        _log.error(e.getLocalizedMessage(), e);
                    }


                    return Mapper.toSubscriptionDto(subscription, offer);
                }).collect(Collectors.toList());

        res.setSubscriptions(subs);
        return res;
    }
}
