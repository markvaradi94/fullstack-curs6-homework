package ro.fasttrackit.productsapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static java.util.Arrays.stream;

@Getter
@RequiredArgsConstructor
public enum ProductCategory {
    DIY("diy"),
    ELECTRONICS("electronics"),
    FOOD("food"),
    FURNITURE("furniture");

    private final String categoryName;

    public static Optional<ProductCategory> getCategoryByName(String categoryName) {
        return stream(ProductCategory.values())
                .filter(product -> product.categoryName.equalsIgnoreCase(categoryName))
                .findFirst();
    }
}
