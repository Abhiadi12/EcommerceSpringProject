package org.example.ecommercespring.configuration;

import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.springframework.beans.factory.annotation.Value;

// we make the configuration for the retrofit.

@Configuration
public class RetrofitConfig {

    @Value("${RETROBASE}")
    private String someConfig;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(someConfig)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductApi.class);
    }

}
