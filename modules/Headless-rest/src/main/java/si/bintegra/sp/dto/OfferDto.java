package si.bintegra.sp.dto;

import lombok.Data;

@Data
public class OfferDto {
    private Long id;

    private String title;
    private String type;
    private String description;
    private Boolean active;

    //mobile fields!!
    private Long mobileData;
    private Long mobileMinutes;
    private Long mobileSms;

    //TV fields!!
    private Long programsNumber;
    private Long defaultNumberOfTvs;

    //internet fields!!
    private Long downloadSpeed;
    private Long uploadSpeed;
}
