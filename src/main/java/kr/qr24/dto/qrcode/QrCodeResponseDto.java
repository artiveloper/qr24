package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class QrCodeResponseDto {

    private Long id;

    private String name;

    private Long qrCodeTypeId;

    private String qrCodeTypeName;

    private String carNumber;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    private LocalDateTime createdAt;

    public QrCodeResponseDto(QrCode qrCode) {
        this.id = qrCode.getId();
        this.name = qrCode.getName();
        this.qrCodeTypeId = qrCode.getQrCodeType().getId();
        this.qrCodeTypeName = qrCode.getQrCodeType().getName();
        this.carNumber = qrCode.getCarNumber();
        this.postcode = qrCode.getPostcode();
        this.roadAddress = qrCode.getRoadAddress();
        this.jibunAddress = qrCode.getJibunAddress();
        this.detailAddress = qrCode.getDetailAddress();
        this.extraAddress = qrCode.getExtraAddress();
        this.businessNumber = qrCode.getBusinessNumber();
        this.managerName = qrCode.getManagerName();
        this.managerPhoneNumber = qrCode.getManagerPhoneNumber();
        this.createdAt = qrCode.getCreatedAt();
    }

}
