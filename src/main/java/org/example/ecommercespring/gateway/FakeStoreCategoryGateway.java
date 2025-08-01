package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.example.ecommercespring.mapper.GetAllCategoryMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Component
@Primary
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // 1. Make the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        // 2. Check if the response is null and throw an IOException if it is
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        // 3. Map the response to a list of CategoryDTO objects
        return GetAllCategoryMapper.toCategoryDto(response);
    }

    @Override
    public List<ProductDTO> getAllProducts(String name) throws IOException {
        // 1. Build the call
        Call<FakeStoreProductResponseDTO> call = this.fakeStoreCategoryApi.getProductsByType(name);

        // 2. Print the URL it will request
        System.out.println("Request URL: " + call.request().url());

        // 3. Execute the call
        Response<FakeStoreProductResponseDTO> retrofitResponse = call.execute();

        // 4. Get the body
        FakeStoreProductResponseDTO response = retrofitResponse.body();

        // 5. Print body (for debugging)
        System.out.println("Response body: " + response);

        if (response == null)
            throw new IOException("Failed to fetch categories from FakeStore API");

        return response.getProducts();
    }

}
