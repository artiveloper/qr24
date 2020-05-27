package kr.qr24.dto;

import kr.qr24.domain.Store;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterStoreFormRequest {

    @NotBlank(message = "매장 정보를 입력해주세요")
    private String name;

    @NotBlank(message = "우편 번호를 입력해주세요")
    private String postcode;

    @NotBlank(message = "도로명 주소를 입력해주세요")
    private String roadAddress;

    @NotBlank(message = "지번 주소를 입력해주세요")
    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    @NotBlank(message = "사업자번호를 입력해주세요")
    private String businessNumber;

    @NotBlank(message = "담당자 성함을 입력해주세요")
    private String managerName;

    @NotBlank(message = "담당자 연락처를 입력해주세요")
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
