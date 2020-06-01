package kr.qr24.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "STORES")
@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QRCODE_ID")
    private Long id;

    private String name;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String addressDetail;

    private String detailAddress;

    private String extraAddress;

    private String carNumber;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QRCODE_TYPE_ID")
    private QrCodeType qrCodeType;

    /*
        연관관계 메서드
     */
    public void setQrCodeType(QrCodeType qrCodeType) {
        this.qrCodeType = qrCodeType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /*
        생성 메서드
     */
    public static QrCode createQrCode(User user, QrCodeType qrCodeType) {
        QrCode QRCode = new QrCode();
        QRCode.setUser(user);
        QRCode.setQrCodeType(qrCodeType);
        QRCode.setCreatedAt(LocalDateTime.now());
        return QRCode;
    }

}
