package ro.fasttrackit.productsclient.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static java.util.Arrays.stream;

@Getter
@RequiredArgsConstructor
public enum ProductCategory {
    DIY,
    ELECTRONICS,
    FOOD,
    FURNITURE;

    public static Optional<ProductCategory> getCategoryByName(String categoryName) {
        return stream(ProductCategory.values())
                .filter(product -> product.name().equalsIgnoreCase(categoryName))
                .findFirst();
    }
}
