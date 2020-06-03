package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class EditQrCodeForm {

    private Long id;

    @NotNull(message = "카테고리를 선택해주세요")
    private Long qrCodeTypeId;

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

    private String carNumber;

    @NotBlank(message = "사업자번호를 입력해주세요")
    private String businessNumber;

    @NotBlank(message = "담당자 성함을 입력해주세요")
    private String managerName;

    @NotBlank(message = "담당자 연락처를 입력해주세요")
    private String managerPhoneNumber;

    public EditQrCodeForm(QrCode qrCode) {
        this.id = qrCode.getId();
        this.qrCodeTypeId = qrCode.getQrCodeType().getId();
        this.name = qrCode.getName();
        this.postcode = qrCode.getPostcode();
        this.roadAddress = qrCode.getRoadAddress();
        this.jibunAddress = qrCode.getJibunAddress();
        this.detailAddress = qrCode.getDetailAddress();
        this.extraAddress = qrCode.getExtraAddress();
        this.carNumber = qrCode.getCarNumber();
        this.businessNumber = qrCode.getBusinessNumber();
        this.managerName = qrCode.getManagerName();
        this.managerPhoneNumber = qrCode.getManagerPhoneNumber();
    }

}
