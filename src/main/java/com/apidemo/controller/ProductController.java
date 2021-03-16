package com.apidemo.controller;

import com.apidemo.entities.Product;
import com.apidemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.baseurl}/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/all")
    public List<Product> save(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/id/{productId}")
    public Product getById(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/name/{productName}")
    public Product getByName(@PathVariable String productName) {
        return productService.getProduct(productName);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }
}