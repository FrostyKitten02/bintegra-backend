package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.remote.cors.annotation.CORS;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.SubscriptionRequest;
import si.bintegra.sp.dto.SubscriptionResponse;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.service.OfferLocalServiceUtil;
import si.bintegra.sp.service.PackageOfferLocalServiceUtil;
import si.bintegra.sp.service.SubscriptionLocalServiceUtil;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/subscription")
@Produces("application/json")
@Consumes("application/json")
@CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
public class SubscriptionController extends Application {
    private static final Log _log = LogFactoryUtil.getLog(SubscriptionController.class);

    @POST
    @Path("/subscribe")
    public void subscribe(@RequestBody SubscriptionRequest req, @Context HttpServletRequest request) throws PortalException {
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserGuestStrict(user);

        SubscriptionDto subDto = req.getSubscription();

        SubscriptionLocalServiceUtil.addSubscription(subDto.getPackageOfferId(), user.getUserId(),subDto.getPhoneId(), subDto.getStartDate());
    }

    @GET
    public SubscriptionResponse getUserSubscriptions(@Context HttpServletRequest request) throws PortalException {
        SubscriptionResponse res = new SubscriptionResponse();
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserGuestStrict(user);

        List<Subscription> all =  SubscriptionLocalServiceUtil.findSubscriptionsByUserId(user.getUserId());
        List<SubscriptionDto> success = new ArrayList<>(all.size());
        List<SubscriptionDto> failed = new ArrayList<>();

        for (Subscription s : all) {
            try {
                PackageOffer packageOffer = PackageOfferLocalServiceUtil.findById(s.getPackageOffer());
                Offer offer = OfferLocalServiceUtil.findById(packageOffer.getOfferId());
                success.add(Mapper.toSubscriptionDto(s, packageOffer, offer));
            } catch (NoSuchPackageOfferException | NoSuchOfferException e) {
                _log.error(e.getLocalizedMessage(), e);
                failed.add(Mapper.toSubscriptionDto(s));
            }
        }

        res.setSubscriptions(success);
        res.setSubscriptionNoData(failed);

        return res;
    }
}
