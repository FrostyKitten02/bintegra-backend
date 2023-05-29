package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class SubscriptionDto {
    private Long packageOfferId;
    private Long startDate;
    private Long phoneId;

    private PackageOfferDto packageOffer;
}
