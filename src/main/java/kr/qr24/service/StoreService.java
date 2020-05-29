package kr.qr24.service;

import kr.qr24.domain.Category;
import kr.qr24.domain.Store;
import kr.qr24.domain.User;
import kr.qr24.dto.RegisterStoreFormRequest;
import kr.qr24.dto.StoreResponseDto;
import kr.qr24.exception.CategoryNotFound;
import kr.qr24.exception.StoreNotFound;
import kr.qr24.exception.UserNotFound;
import kr.qr24.repository.CategoryRepository;
import kr.qr24.repository.UserRepository;
import kr.qr24.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long registerStore(Long userId, RegisterStoreFormRequest registerStoreFormRequest) {
        Store store = registerStoreFormRequest.toStoreEntity();
        Long categoryId = registerStoreFormRequest.getCategoryId();

        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFound::new);

        store.setUser(user);
        store.setCategory(category);

        storeRepository.save(store);
        return store.getId();
    }

    public List<StoreResponseDto> getStores(Long userId) {
        return storeRepository.findStoresByUserId(userId)
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
