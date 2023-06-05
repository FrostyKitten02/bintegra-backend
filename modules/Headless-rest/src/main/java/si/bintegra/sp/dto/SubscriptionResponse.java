package si.bintegra.sp.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubscriptionResponse {
    private Long subscriptionId;
    private List<SubscriptionDto> subscriptions;
}
