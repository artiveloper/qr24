package kr.qr24.service;

import kr.qr24.dto.CategoryResponseDto;
import kr.qr24.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }

}
