package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


import java.io.IOException;

public interface FakeStoreCategoryApi {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;

    @GET("products/category")
    Call<FakeStoreProductResponseDTO> getProductsByType(@Query("type") String type) throws IOException;
}
