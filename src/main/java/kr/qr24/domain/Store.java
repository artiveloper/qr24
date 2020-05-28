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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long id;

    private String name;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String addressDetail;

    private String detailAddress;

    private String extraAddress;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    /*
        연관관계 메서드
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
