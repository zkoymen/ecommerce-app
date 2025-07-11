package com.ecommerce.ecommerce_app.services;

import com.ecommerce.ecommerce_app.controllers.ResourceNotFoundException;
import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.entities.Product;
import com.ecommerce.ecommerce_app.mappers.ProductMapper;
import com.ecommerce.ecommerce_app.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// logging purposes
@Slf4j
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
    public Optional<ProductDTO> getById(Long id) {

        return  productRepository.findById(id)
                .map(mapper::toDTO);
    }

    @Override
    public List<ProductDTO> listAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, ProductDTO dto) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found" + id));
        mapper.updateFromDto(dto, existing);
        productRepository.save(existing);
        log.debug("Updated product with Id {}", id);

    }

    @Override
    public void delete(Long id) {

        if(!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }


        productRepository.deleteById(id);
        log.debug("Deleted product with ID {}", id);

    }

    // No need for patch -- update logic is moved to mapper
}
