package org.example.ecommercespring.gateway.api;
import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.io.IOException;


public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<FakeStoreSingleProductResponseDTO> getFakeProduct(@Path("id") Long id) throws IOException;
}
