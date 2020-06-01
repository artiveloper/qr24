package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCode;
import lombok.Data;

@Data
public class QrCodeListResponse {

    private Long id;

    private String name;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    public QrCodeListResponse(QrCode QRCode) {
        this.id = QRCode.getId();
        this.name = QRCode.getName();
        this.roadAddress = QRCode.getRoadAddress();
        this.jibunAddress = QRCode.getJibunAddress();
        this.detailAddress = QRCode.getDetailAddress();
        this.extraAddress = QRCode.getExtraAddress();
    }

}
