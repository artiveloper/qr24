package kr.qr24.repository.store;

import kr.qr24.domain.QStore;
import kr.qr24.domain.Store;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class StoreSupportRepositoryImpl extends QuerydslRepositorySupport implements StoreSupportRepository {

    public StoreSupportRepositoryImpl() {
        super(Store.class);
    }

    public List<Store> findStoresByUserId(Long userId) {
        final QStore store = QStore.store;
        return from(store)
                .where(store.user.id.eq(userId))
                .fetch();
    }

}
