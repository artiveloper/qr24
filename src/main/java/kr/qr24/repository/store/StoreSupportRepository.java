package kr.qr24.repository.store;

import kr.qr24.domain.Store;

import java.util.List;

public interface StoreSupportRepository {

    List<Store> findStoresByUserId(Long userId);

}
