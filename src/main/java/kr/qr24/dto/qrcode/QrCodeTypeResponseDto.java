package kr.qr24.dto.qrcode;

import kr.qr24.domain.QrCodeType;
import lombok.Data;

@Data
public class QrCodeTypeResponseDto {

    private Long id;

    private String name;

    public QrCodeTypeResponseDto(QrCodeType qrCodeType) {
        this.id = qrCodeType.getId();
        this.name = qrCodeType.getName();
    }

}
