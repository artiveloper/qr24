package kr.qr24.repository.qrcode;

import kr.qr24.domain.QQrCode;
import kr.qr24.domain.QQrCodeType;
import kr.qr24.domain.QrCode;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class QrCodeSupportRepositoryImpl extends QuerydslRepositorySupport implements QrCodeSupportRepository {

    public QrCodeSupportRepositoryImpl() {
        super(QrCode.class);
    }

    public List<QrCode> findQrCodesByUserId(Long userId) {
        final QQrCode qrCode = QQrCode.qrCode;
        final QQrCodeType qrCodeType = QQrCodeType.qrCodeType;
        return from(qrCode)
                .leftJoin(qrCode.qrCodeType, qrCodeType)
                .fetchJoin()
                .where(qrCode.user.id.eq(userId))
                .fetch();
    }

    public QrCode findQrCodeWithType(Long storeId) {
        final QQrCode qrCode = QQrCode.qrCode;
        final QQrCodeType qrCodeType = QQrCodeType.qrCodeType;

        return from(qrCode)
                .leftJoin(qrCode.qrCodeType, qrCodeType)
                .fetchJoin()
                .where(qrCode.id.eq(storeId))
                .fetchOne();
    }

}
