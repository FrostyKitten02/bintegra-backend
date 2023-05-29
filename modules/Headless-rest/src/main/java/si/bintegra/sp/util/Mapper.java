package si.bintegra.sp.util;

import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.model.Subscription;

public class Mapper {

    public static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        SubscriptionDto dto = new SubscriptionDto();
        dto.setPackageOffer(subscription.getPackageOffer());
        return dto;
    }

}
