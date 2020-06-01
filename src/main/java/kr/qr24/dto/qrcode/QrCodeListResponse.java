package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCode;
import lombok.Data;

@Data
public class QrCodeListResponse {

    private Long id;

    private String name;

    private Long qrCodeTypeId;

    private String carNumber;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    public QrCodeListResponse(QrCode qrCode) {
        this.id = qrCode.getId();
        this.name = qrCode.getName();
        this.qrCodeTypeId = qrCode.getQrCodeType().getId();
        this.carNumber = qrCode.getCarNumber();
        this.roadAddress = qrCode.getRoadAddress();
        this.jibunAddress = qrCode.getJibunAddress();
        this.detailAddress = qrCode.getDetailAddress();
        this.extraAddress = qrCode.getExtraAddress();
    }

}
