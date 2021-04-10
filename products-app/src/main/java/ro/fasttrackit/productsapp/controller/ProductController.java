package ro.fasttrackit.productsapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.productsapp.domain.Product;
import ro.fasttrackit.productsapp.exceptions.ResourceNotFoundException;
import ro.fasttrackit.productsapp.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Double maxPrice) {
        return productService.getProducts(category, maxPrice);
    }

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product"));
    }

    @PostMapping
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @DeleteMapping("{productId}")
    public Product deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product"));
    }
}
