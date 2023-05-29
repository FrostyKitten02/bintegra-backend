package si.bintegra.sp.util;

import si.bintegra.sp.dto.OfferDto;
import si.bintegra.sp.dto.PackageOfferDto;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.model.Subscription;

public class Mapper {


    public static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        return toSubscriptionDto(subscription, null, null);
    }
    public static SubscriptionDto toSubscriptionDto(Subscription subscription, PackageOffer packageOffer, Offer offer) {
        if (subscription == null) {
            return null;
        }

        SubscriptionDto dto = new SubscriptionDto();
        dto.setPackageOfferId(subscription.getPackageOffer());
        dto.setPhoneId(subscription.getPhoneId());
        dto.setPackageOffer(toPackageOfferDto(packageOffer, offer));
        dto.setStartDate(subscription.getStartDate());

        return dto;
    }

    public static PackageOfferDto toPackageOfferDto(PackageOffer packageOffer) {
        return toPackageOfferDto(packageOffer, null);
    }
    public static PackageOfferDto toPackageOfferDto(PackageOffer packageOffer, Offer offer) {
        if (packageOffer == null) {
            return null;
        }

        PackageOfferDto dto = new PackageOfferDto();
        dto.setId(packageOffer.getId());
        dto.setDiscountPrice(packageOffer.getDiscountPrice());
        dto.setBasePrice(packageOffer.getBasePrice());
        dto.setDiscountDuration(packageOffer.getDiscountDuration());
        dto.setFullDuration(packageOffer.getFullDuration());
        dto.setOffer(toOfferDto(offer));

        return dto;
    }

    public static OfferDto toOfferDto(Offer offer) {
        if (offer == null) {
            return null;
        }

        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setType(offer.getType());
        dto.setDescription(offer.getDescription());
        dto.setActive(offer.getActive());

        dto.setMobileData(offer.getMobileData());
        dto.setMobileMinutes(offer.getMobileMinutes());
        dto.setMobileSms(offer.getMobileSms());

        dto.setProgramsNumber(offer.getProgramsNumber());
        dto.setDefaultNumberOfTvs(offer.getDefaultNumberOfTvs());

        dto.setDownloadSpeed(offer.getDownloadSpeed());
        dto.setUploadSpeed(offer.getUploadSpeed());
        return dto;
    }

}
