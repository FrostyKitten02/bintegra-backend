package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.PackageOfferDto;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.SubscriptionRequest;
import si.bintegra.sp.dto.SubscriptionResponse;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.service.OfferService;
import si.bintegra.sp.service.PackageOfferService;
import si.bintegra.sp.service.SubscriptionService;
import si.bintegra.sp.util.Mapper;


import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = SubscriptionController.class
)
@Path("/subscription")
@Produces("application/json")
@Consumes("application/json")
public class SubscriptionController extends Application {
    @Reference
    private SubscriptionService subscriptionService;
    @Reference
    private OfferService offerService;
    @Reference
    private PackageOfferService packageOfferService;

    private static final Log _log = LogFactoryUtil.getLog(SubscriptionController.class);

    @POST
    @Path("/subscribe")
    public void subscribe(@RequestBody SubscriptionRequest req, @Context HttpServletRequest request) throws PortalException {
        User user = PortalUtil.getUser(request);
        SubscriptionDto subDto = req.getSubscription();

        subscriptionService.addSubscription(subDto.getPackageOfferId(), user.getUserId(),subDto.getPhoneId(), subDto.getStartDate());
    }

    @GET
    public SubscriptionResponse getUserSubscriptions(@Context HttpServletRequest request) throws PortalException {
        SubscriptionResponse res = new SubscriptionResponse();
        User user = PortalUtil.getUser(request);
        List<Subscription> all =  subscriptionService.findSubscriptionsByUserId(user.getUserId());
        List<SubscriptionDto> success = new ArrayList<>(all.size());
        List<SubscriptionDto> failed = new ArrayList<>();

        for (Subscription s : all) {
            try {
                PackageOffer packageOffer = packageOfferService.findById(s.getPackageOffer());
                Offer offer = offerService.findById(packageOffer.getOfferId());
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
