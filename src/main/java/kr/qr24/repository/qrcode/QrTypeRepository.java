package kr.qr24.repository.qrcode;

import kr.qr24.domain.QrCodeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrTypeRepository extends JpaRepository<QrCodeType, Long> {
}
