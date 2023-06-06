package si.bintegra.sp.util;

import com.liferay.portal.kernel.model.User;
import si.bintegra.sp.dto.OfferDto;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.UserDto;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.Subscription;

public class Mapper {


    public static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        return toSubscriptionDto(subscription, null);
    }
    public static SubscriptionDto toSubscriptionDto(Subscription subscription, Offer offer) {
        if (subscription == null) {
            return null;
        }

        SubscriptionDto dto = new SubscriptionDto();
        dto.setOfferId(subscription.getOfferId());
        dto.setPhoneId(subscription.getPhoneId());
        dto.setStartDate(subscription.getStartDate());

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

        //mobile
        dto.setMobileData(offer.getMobileData());
        dto.setMobileMinutes(offer.getMobileMinutes());
        dto.setMobileSms(offer.getMobileSms());

        //tv
        dto.setProgramsNumber(offer.getProgramsNumber());
        dto.setDefaultNumberOfTvs(offer.getDefaultNumberOfTvs());

        //internet
        dto.setDownloadSpeed(offer.getDownloadSpeed());
        dto.setUploadSpeed(offer.getUploadSpeed());

        //duration
        dto.setFullDurationMonths(offer.getFullDurationMonths());
        dto.setDiscountDurationMonths(offer.getDiscountDurationMonths());

        //pricing
        dto.setBasePrice(offer.getBasePrice());
        dto.setDiscountPrice(offer.getDiscountPrice());

        return dto;
    }

    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setEmail(user.getEmailAddress());
        dto.setId(user.getUserId());
        dto.setFirstname(user.getFirstName());
        dto.setLastname(user.getLastName());

        return dto;
    }

    public static UserDto toUserDto(User user, boolean isConsultant) {
        UserDto dto = toUserDto(user);
        dto.setIsConsultant(isConsultant);
        return dto;
    }

}
