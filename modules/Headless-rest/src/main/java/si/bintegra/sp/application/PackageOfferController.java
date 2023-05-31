package si.bintegra.sp.application;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.remote.cors.annotation.CORS;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.PackageOfferDto;
import si.bintegra.sp.dto.PackageOfferRequest;
import si.bintegra.sp.dto.PackageOfferResponse;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.service.OfferLocalServiceUtil;
import si.bintegra.sp.service.PackageOfferLocalServiceUtil;
import si.bintegra.sp.service.PackageOfferServiceUtil;
import si.bintegra.sp.util.Mapper;
import si.bintegra.sp.util.RoleChecker;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        properties = "defaultController.properties",
        scope = ServiceScope.PROTOTYPE,
        service = PackageOfferController.class
)
@Path("/package-offer")
@Produces("application/json")
@Consumes("application/json")
@CORS(allowMethods = "*", allowHeaders = "*", allowOrigin = "*")
public class PackageOfferController extends Application {


    @GET
    @Path("/active/{type}")
    public PackageOfferResponse getActivePackageOfferByType(@PathParam("type") String type) throws NoSuchOfferException {
        PackageOfferResponse res = new PackageOfferResponse();
        List<PackageOfferDto> packageOfferDtos = PackageOfferLocalServiceUtil.findActiveByOfferType(type).stream().map(Mapper::toPackageOfferDto).collect(Collectors.toList());
        res.setPackageOffers(packageOfferDtos);
        return res;
    }

    @POST
    public PackageOfferResponse createPackageOffer(@RequestBody PackageOfferRequest req, @Context HttpServletRequest request) throws PortalException {
        PackageOfferResponse res = new PackageOfferResponse();
        RoleChecker.isUserAdministratorStrict(PortalUtil.getUser(request));

        PackageOfferDto dto = req.getPackageOffer();
        if (dto.getOfferId() == null) {
            throw new IllegalArgumentException("missingOfferId");
        }
        PackageOffer packageOffer = PackageOfferServiceUtil.createPackageOffer(dto.getOfferId(), dto.getFullDuration(), dto.getDiscountDuration(), dto.getDiscountPrice(), dto.getBasePrice(), dto.getActive());
        res.setPackageOffer(Mapper.toPackageOfferDto(packageOffer, OfferLocalServiceUtil.findById(packageOffer.getOfferId())));
        return res;
    }


}
