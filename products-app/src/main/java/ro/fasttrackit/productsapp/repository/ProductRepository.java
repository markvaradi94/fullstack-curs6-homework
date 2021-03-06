package ro.fasttrackit.productsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.productsapp.domain.Product;
import ro.fasttrackit.productsapp.enums.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByProductCategory(ProductCategory category);

    List<Product> findAllByPriceIsLessThanEqual(Double maxPrice);

    List<Product> findAllByProductCategoryAndPriceIsLessThanEqual(ProductCategory category, Double maxPrice);
}
