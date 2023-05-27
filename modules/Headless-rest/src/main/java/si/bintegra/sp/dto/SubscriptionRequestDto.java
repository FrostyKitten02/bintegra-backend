package si.bintegra.sp.dto;


import lombok.Data;

@Data
public class SubscriptionRequestDto {
    private Long packageOfferId;
    private Long duration;
    private Long phoneId;
}
