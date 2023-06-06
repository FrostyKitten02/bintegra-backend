package si.bintegra.sp.dto.response;

import lombok.Data;
import si.bintegra.sp.dto.SubscriptionDto;
import si.bintegra.sp.dto.UserDto;

import java.util.List;

@Data
public class ConsultantResponse {
    private List<UserDto> customers;
    private List<SubscriptionDto> customerSubscriptions;
    private Long customerId;
}
