package com.ecommerce.ecommerce_app.controllers;


import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ProductController.PRODUCT_PATH)
@RequiredArgsConstructor
public class ProductController {

    // Define paths as constant --> good practice
    public static final String PRODUCT_PATH = "/api/products";
    public static final String ID_PATH = "/{id}";

    // Create a service instance
    // Required Argument constructor
    private final ProductService productService;






    // RequestBody   --> as JSON
    // @PathVariable --> url



    // CREATE A NEW PRODUCT
    @PostMapping
    public ResponseEntity create(@RequestBody ProductDTO dto) {

        ProductDTO savedProduct = productService.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", PRODUCT_PATH + savedProduct.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    // Get product by id
    @GetMapping(ID_PATH)
    public ProductDTO getById(@PathVariable("id") Long id) {
        return productService.getById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping
    public List<ProductDTO> listAll() {

        return productService.listAll();
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<ProductDTO> update(@PathVariable("id") Long id, @RequestBody ProductDTO dto) {

        // Call the service first!
        productService.update(id, dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity delete(@PathVariable Long id) {

        productService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
