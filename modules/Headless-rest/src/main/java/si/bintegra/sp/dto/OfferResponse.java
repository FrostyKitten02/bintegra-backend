package si.bintegra.sp.dto;

import lombok.Data;

import java.util.List;

@Data
public class OfferResponse {
    private OfferDto offer;
    private List<OfferWithPackageOffersDto> offersWithPackageOffers;
}
