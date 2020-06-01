package kr.qr24.repository.qrcode;

import kr.qr24.domain.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QrCodeRepository extends JpaRepository<QrCode, Long>, QrCodeSupportRepository, QuerydslPredicateExecutor<QrCode> {

}
