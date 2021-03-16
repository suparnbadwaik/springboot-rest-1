package com.apidemo.service;

import com.apidemo.entities.Product;
import com.apidemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(int productId) {
        // return productRepository.getOne(productId);
        return productRepository.findById(productId).orElse(null);
    }

    public Product getProduct(String productName) {
        return productRepository.findByName(productName);
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
        log.info("Product " + productId + " deleted !!!");
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(product);
    }
}