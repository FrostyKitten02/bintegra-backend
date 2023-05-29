package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class PackageOfferDto {
    private long id;

    private Long offerId;
    private Long fullDuration;
    private Long discountDuration;

    private Double discountPrice;
    private Double basePrice;
    private Boolean active;

    private OfferDto offer;
}
