package si.bintegra.sp.dto;

import lombok.Data;

import java.util.List;

@Data
public class PackageOfferResponse {
    private PackageOfferDto packageOffer;
    private List<PackageOfferDto> packageOffers;
}
