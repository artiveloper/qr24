package kr.qr24.dto;

import kr.qr24.domain.Store;
import lombok.Data;

@Data
public class RegisterStoreFormRequest {

    private String name;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    public Store toStoreEntity() {
        return Store.builder()
                .name(this.name)
                .postcode(this.postcode)
                .roadAddress(this.roadAddress)
                .jibunAddress(this.jibunAddress)
                .detailAddress(this.detailAddress)
                .extraAddress(this.extraAddress)
                .businessNumber(this.businessNumber)
                .managerName(this.managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .build();
    }

}
