package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.mapper.GetAllCategoryMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway") // solve the ambiguity issue
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";

        ResponseEntity<FakeStoreCategoryResponseDTO> response =  restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return GetAllCategoryMapper.toCategoryDto(response.getBody()); // Adapter pattern
    }

    @Override
    public  List<ProductDTO> getAllProducts(String name) throws IOException {
        return List.of();
    }

}
