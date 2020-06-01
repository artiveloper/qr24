package kr.qr24.repository.qrcode;

import kr.qr24.domain.QrCode;

import java.util.List;

public interface QrCodeSupportRepository {

    List<QrCode> findQrCodesByUserId(Long userId);

    QrCode findQrCodeWithType(Long storeId);

}
