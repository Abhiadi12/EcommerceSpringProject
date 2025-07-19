package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreSingleProductResponseDTO {
    private boolean status;
    private String message;
    private ProductDTO product;
}
