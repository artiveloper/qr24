package kr.qr24.service;

import kr.qr24.domain.Store;
import kr.qr24.dto.RegisterStoreFormRequest;
import kr.qr24.dto.StoreResponseDto;
import kr.qr24.exception.StoreNotFound;
import kr.qr24.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public Long registerStore(RegisterStoreFormRequest registerStoreFormRequest) {
        Store store = registerStoreFormRequest.toStoreEntity();
        storeRepository.save(store);
        return store.getId();
    }

    public List<StoreResponseDto> getStores(Long userId) {
        return storeRepository.findAll()
                .stream()
                .map(StoreResponseDto::new)
                .collect(Collectors.toList());
    }

    public StoreResponseDto getStore(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotFound::new);
        return new StoreResponseDto(store);
    }

}
