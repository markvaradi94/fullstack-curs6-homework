package ro.fasttrackit.productsapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.productsapp.domain.Product;
import ro.fasttrackit.productsapp.service.ProductService;

import static ro.fasttrackit.productsapp.enums.ProductCategory.ELECTRONICS;
import static ro.fasttrackit.productsapp.enums.ProductCategory.*;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ProductService productService;

    @Override
    public void run(String... args) {
        productService.addProduct(Product.builder()
                .name("TV")
                .price(2299.50)
                .description("Big and shiny")
                .productCategory(ELECTRONICS)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("Apples")
                .price(2.50)
                .description("Tasty")
                .productCategory(FOOD)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("HAMMER")
                .price(29.13)
                .description("Handy")
                .productCategory(DIY)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("SOFA")
                .price(1199.50)
                .description("Big and comft")
                .productCategory(FURNITURE)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("PC")
                .price(5299.50)
                .description("Fast and reliable")
                .productCategory(ELECTRONICS)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("Radio")
                .price(299.50)
                .description("Portable")
                .productCategory(ELECTRONICS)
                .build()
        );
        productService.addProduct(Product.builder()
                .name("Carrots")
                .price(7.22)
                .description("Orange stuff")
                .productCategory(FOOD)
                .build()
        );
    }
}
