package si.bintegra.sp.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import si.bintegra.sp.dto.OfferDto;
import si.bintegra.sp.dto.OfferResponse;
import si.bintegra.sp.dto.OfferWithPackageOffersDto;
import si.bintegra.sp.dto.PackageOfferDto;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.service.OfferService;
import si.bintegra.sp.service.PackageOfferService;
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
        service = OfferController.class
)
@Path("/offer")
@Produces("application/json")
@Consumes("application/json")
public class OfferController extends Application {

    @Reference
    private OfferService offerService;
    @Reference
    private PackageOfferService packageOfferService;

    @GET
    @Path("/active/{type}")
    public OfferResponse getActiveOffersByTypeWithActivePackageOffers(@PathParam("type") String type) {
        OfferResponse res = new OfferResponse();

        List<OfferWithPackageOffersDto> activeOffersWithPackageOffers = offerService.findActiveByType(type).stream().map(offer -> {
            List<PackageOfferDto> activePackageOffers = packageOfferService
                    .findActiveByOfferId(offer.getId())
                    .stream().map(Mapper::toPackageOfferDto)
                    .collect(Collectors.toList());
            return new OfferWithPackageOffersDto(Mapper.toOfferDto(offer), activePackageOffers);
        }).collect(Collectors.toList());

        res.setOffersWithPackageOffers(activeOffersWithPackageOffers);

        return res;
    }

    @GET
    @Path("/{id}")
    public OfferResponse getOffer(@PathParam("id") long id) throws NoSuchOfferException {
        OfferResponse res = new OfferResponse();
        res.setOffer(Mapper.toOfferDto(offerService.findById(id)));
        return res;
    }

    @POST
    public OfferResponse createOffer(@RequestBody OfferResponse req, @Context HttpServletRequest request) throws PortalException, IllegalAccessException {
        RoleChecker.isUserAdministratorStrict(PortalUtil.getUser(request));
        OfferResponse res = new OfferResponse();

        OfferDto offerDto = req.getOffer();
        Offer saved = offerService.addOffer(offerDto.getTitle(), offerDto.getType(), offerDto.getDescription(), offerDto.getActive(), offerDto.getMobileData(), offerDto.getMobileMinutes(), offerDto.getMobileSms(), offerDto.getProgramsNumber(), offerDto.getDefaultNumberOfTvs(), offerDto.getDownloadSpeed(), offerDto.getUploadSpeed());
        res.setOffer(Mapper.toOfferDto(saved));

        return res;
    }

}
