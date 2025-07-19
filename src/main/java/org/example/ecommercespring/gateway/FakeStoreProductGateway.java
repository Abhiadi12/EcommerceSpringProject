package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        FakeStoreSingleProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        if (response == null) {
            throw new Exception("Product not found");
        }

        return response.getProduct();
    }
}