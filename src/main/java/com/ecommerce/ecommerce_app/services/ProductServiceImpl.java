package com.ecommerce.ecommerce_app.services;

import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.entities.Product;
import com.ecommerce.ecommerce_app.mappers.ProductMapper;
import com.ecommerce.ecommerce_app.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    // Create the repos
    private final ProductRepository productRepository;
    private final ProductMapper mapper;


    // Service → Mapper → Controller → DTO
    // Using DTO instead of POJOs is a little overkill for simple projects


    @Override
    public ProductDTO create(ProductDTO dto) {
        Product saved = productRepository.save(mapper.toEntity(dto));
        return mapper.toDTO(saved);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return  mapper.toDTO(p);
    }

    @Override
    public List<ProductDTO> listAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(Long id, ProductDTO dto) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // copy fields --> update requests: all parts must be provided
        // patch --> partial update
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setStockQuantity(dto.getStockQuantity());


        Product updated = productRepository.save(existing);
        return mapper.toDTO(updated);


    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }
}
