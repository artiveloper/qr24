package kr.qr24.dto.store;

import kr.qr24.domain.Store;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreResponseDto {

    private Long id;

    private String name;

    private String categoryName;

    private String postcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    private String businessNumber;

    private String managerName;

    private String managerPhoneNumber;

    private LocalDateTime createdAt;

    public StoreResponseDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.categoryName = store.getCategory().getName();
        this.postcode = store.getPostcode();
        this.roadAddress = store.getRoadAddress();
        this.jibunAddress = store.getJibunAddress();
        this.detailAddress = store.getDetailAddress();
        this.extraAddress = store.getExtraAddress();
        this.businessNumber = store.getBusinessNumber();
        this.managerName = store.getManagerName();
        this.managerPhoneNumber = store.getManagerPhoneNumber();
        this.createdAt = store.getCreatedAt();
    }

}
