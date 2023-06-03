package si.bintegra.sp.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubscriptionResponse {
    private List<SubscriptionDto> subscriptions;
}
