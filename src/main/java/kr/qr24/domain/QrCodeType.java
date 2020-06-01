package kr.qr24.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "QRCODE_TYPES")
@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrCodeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QRCODE_TYPE_ID")
    private Long id;

    private String name;

}
