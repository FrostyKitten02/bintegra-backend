package si.bintegra.sp.custom;

import lombok.Data;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;


@Data
public class OfferAndPackageOffer {
    private Offer offer;
    private PackageOffer packageOffer;
}
