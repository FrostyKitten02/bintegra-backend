package si.bintegra.sp.dto.response;

import lombok.Data;
import si.bintegra.sp.dto.SubscriptionDto;

import java.util.List;

@Data
public class SubscriptionResponse {
    private Long subscriptionId;
    private List<SubscriptionDto> subscriptions;
}
