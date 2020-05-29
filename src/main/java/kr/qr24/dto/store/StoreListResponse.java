package kr.qr24.dto.store;

import kr.qr24.domain.Store;
import lombok.Data;

@Data
public class StoreListResponse {

    private Long id;

    private String name;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    private String extraAddress;

    public StoreListResponse(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.roadAddress = store.getRoadAddress();
        this.jibunAddress = store.getJibunAddress();
        this.detailAddress = store.getDetailAddress();
        this.extraAddress = store.getExtraAddress();
    }

}
