package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class SubscriptionDto {
    private Long offerId;
    private Long startDate;
    private Long phoneId;
    private Boolean subscriptionContract;

    private OfferDto offer;
}
