package si.bintegra.sp.dto;


import lombok.Data;

@Data
public class SubscriptionRequestDto {
    private Long offerId;
    private Long duration;
    private Long phoneId;
}
