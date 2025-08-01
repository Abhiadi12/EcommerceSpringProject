package org.example.ecommercespring.mapper;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoryMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO() {
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto) {
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}