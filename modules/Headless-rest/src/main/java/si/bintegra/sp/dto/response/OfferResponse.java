package si.bintegra.sp.dto.response;

import lombok.Data;
import si.bintegra.sp.dto.OfferDto;

import java.util.List;

@Data
public class OfferResponse {
    private OfferDto offer;
    private List<OfferDto> offers;
}
