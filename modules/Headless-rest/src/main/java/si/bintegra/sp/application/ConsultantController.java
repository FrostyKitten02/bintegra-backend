package si.bintegra.sp.application;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.Subscription;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.OfferDto;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.UserDto;
import si.bintegra.sp.dto.request.ConsultantRequest;
import si.bintegra.sp.dto.response.ConsultantResponse;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.service.*;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = ConsultantController.class
)
@Path("/consultant")
@Produces("application/json")
@Consumes("application/json")
public class ConsultantController extends Application {

    private static final Log _log = LogFactoryUtil.getLog(SubscriptionController.class);
    @POST
    public String addConsultant(@RequestBody ConsultantRequest req, @Context HttpServletRequest request) throws PortalException {
        if (req.getUserId() == null) {
            throw new IllegalArgumentException("userIdIsRequired");
        }

        RoleChecker.isUserAdministratorStrict(PortalUtil.getUser(request));

        ConsultantLocalServiceUtil.addConsultant(req.getUserId());
        return "";
    }


    @GET
    public ConsultantResponse getConsultantCustomers(@Context HttpServletRequest request) throws PortalException {
        ConsultantResponse res = new ConsultantResponse();
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserConsultantStrict(user);

        List<Long> customerIds =  ConsultantCustomerLocalServiceUtil.getConsultantCustomerIdsByConsultantUserId(user.getUserId());

        res.setCustomers(customerIds.stream().map(id -> {
            try {
                return Mapper.toUserDto(UserLocalServiceUtil.getUserById(id));
            } catch (PortalException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList()));

        return res;
    }

    @GET
    @Path("/{id}")
    public ConsultantResponse getConsultantCustomerSubscriptions(@PathParam("id") @NotNull Long id, @Context HttpServletRequest request) throws PortalException {
        ConsultantResponse res = new ConsultantResponse();
        User user = PortalUtil.getUser(request);
        RoleChecker.isUserConsultantStrict(user);

        //TODO: check if consultant is actually consultant of this customer, not really that important
        res.setCustomerSubscriptions(SubscriptionLocalServiceUtil.findSubscriptionsByUserId(id).stream().map(sub -> {
            Offer offer = null;
            try {
                offer = OfferLocalServiceUtil.findById(sub.getOfferId());
            } catch (NoSuchOfferException e) {
                _log.error("OfferByIdNotFoundInDbForSubscription",e);
            }

            return Mapper.toSubscriptionDto(sub, offer);
        }).collect(Collectors.toList()));
        res.setCustomerId(id);
        return res;
    }


}
