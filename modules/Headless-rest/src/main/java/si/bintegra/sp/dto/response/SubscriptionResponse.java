package si.bintegra.sp.dto.response;

import lombok.Data;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.UserDto;

import java.util.List;

@Data
public class SubscriptionResponse {
    private Long subscriptionId;
    private UserDto user;
    private List<SubscriptionDto> subscriptions;
}
