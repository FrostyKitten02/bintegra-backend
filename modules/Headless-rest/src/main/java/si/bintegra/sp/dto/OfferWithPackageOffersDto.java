package si.bintegra.sp.dto;

import lombok.Data;

import java.util.List;

@Data
public class OfferWithPackageOffersDto extends OfferDto {
    public OfferWithPackageOffersDto() {
        super();
    }
    public OfferWithPackageOffersDto(OfferDto offerDto, List<PackageOfferDto> packageOffer) {
        super();
        this.setId(offerDto.getId());
        this.setTitle(offerDto.getTitle());
        this.setType(offerDto.getType());
        this.setDescription(offerDto.getDescription());
        this.setActive(offerDto.getActive());
        this.setMobileData(offerDto.getMobileData());
        this.setMobileMinutes(offerDto.getMobileMinutes());
        this.setMobileSms(offerDto.getMobileSms());
        this.setProgramsNumber(offerDto.getProgramsNumber());
        this.setDefaultNumberOfTvs(offerDto.getDefaultNumberOfTvs());
        this.setDownloadSpeed(offerDto.getDownloadSpeed());
        this.setUploadSpeed(offerDto.getUploadSpeed());
        this.packageOffer = packageOffer;
    }


    private List<PackageOfferDto> packageOffer;
}
