package kr.qr24.repository.store;

import kr.qr24.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreSupportRepository, QuerydslPredicateExecutor<Store> {

}
