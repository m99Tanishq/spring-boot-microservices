package com.project.microservices.product.service;

import com.project.microservices.product.dto.ProductDTO;
import com.project.microservices.product.dto.ProductResponse;
import com.project.microservices.product.model.Product;
import com.project.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService
{
   private final ProductRepository productRepository;

   public ProductResponse createProduct(ProductDTO productdto){
       Product product = Product.builder()
               .name(productdto.name())
               .description(productdto.description())
               .price(productdto.price())
               .build();
       productRepository.save(product);
       log.info("Product created successfully");
       return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
   }

    public List<ProductResponse> getAllProducts()
    {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

}
