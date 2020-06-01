package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCode;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QrCodeResponseDto {

    private Long id;

    private String name;

    private String categoryName;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    private LocalDateTime createdAt;

    public QrCodeResponseDto(QrCode QRCode) {
        this.id = QRCode.getId();
        this.name = QRCode.getName();
        this.categoryName = QRCode.getQrCodeType().getName();
        this.postcode = QRCode.getPostcode();
        this.roadAddress = QRCode.getRoadAddress();
        this.jibunAddress = QRCode.getJibunAddress();
        this.detailAddress = QRCode.getDetailAddress();
        this.extraAddress = QRCode.getExtraAddress();
        this.businessNumber = QRCode.getBusinessNumber();
        this.managerName = QRCode.getManagerName();
        this.managerPhoneNumber = QRCode.getManagerPhoneNumber();
        this.createdAt = QRCode.getCreatedAt();
    }

}
