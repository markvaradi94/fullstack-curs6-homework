package ro.fasttrackit.productsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.productsapp.domain.Product;
import ro.fasttrackit.productsapp.enums.ProductCategory;
import ro.fasttrackit.productsapp.exceptions.ResourceNotFoundException;
import ro.fasttrackit.productsapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProducts(String categoryName, Double maxPrice) {
        if (categoryName != null && maxPrice == null) {
            return filterProductsByCategory(categoryName);
        } else if (categoryName == null && maxPrice != null) {
            return filterProductsByMaxPrice(maxPrice);
        } else if (categoryName != null) {
            return filterProductByCategoryAndMaxPrice(categoryName, maxPrice);
        }
        return allProducts();
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Optional<Product> deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        productOptional.ifPresent(productRepository::delete);
        return productOptional;
    }

    private List<Product> allProducts() {
        return unmodifiableList(productRepository.findAll());
    }

    private List<Product> filterProductsByCategory(String categoryName) {
        ProductCategory categoryToFilter = findProductCategory(categoryName);
        return unmodifiableList(productRepository.findAllByProductCategory(categoryToFilter));
    }

    private List<Product> filterProductsByMaxPrice(Double maxPrice) {
        return unmodifiableList(productRepository.findAllByPriceIsLessThanEqual(maxPrice));
    }

    private List<Product> filterProductByCategoryAndMaxPrice(String categoryName, Double maxPrice) {
        ProductCategory categoryToFilter = findProductCategory(categoryName);
        return unmodifiableList(
                productRepository.findAllByProductCategoryAndPriceIsLessThanEqual(categoryToFilter, maxPrice)
        );
    }

    private ProductCategory findProductCategory(String categoryName) {
        return ProductCategory.getCategoryByName(categoryName)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product category."));
    }
}
