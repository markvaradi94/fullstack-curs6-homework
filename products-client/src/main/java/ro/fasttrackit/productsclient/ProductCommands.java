package ro.fasttrackit.productsclient;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.productsclient.model.Product;
import ro.fasttrackit.productsclient.service.ProductService;

import java.util.Scanner;

import static ro.fasttrackit.productsclient.enums.ProductCategory.ELECTRONICS;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("Print all products")
    void printAllProducts() {
        productService.getAllProducts()
                .forEach(System.out::println);
    }

    @ShellMethod("Filter products by price")
    void priceFilteredProducts() {
        System.out.print("maxPrice: ");
        Scanner scanner = new Scanner(System.in);
        double maxPrice = scanner.nextDouble();
        productService.filterProductsByPrice(maxPrice)
                .forEach(System.out::println);
    }

    @ShellMethod("Filter products by category")
    void categoryFilteredProducts() {
        System.out.print("category name: ");
        Scanner scanner = new Scanner(System.in);
        String categoryName = scanner.next();
        productService.filterProductByCategory(categoryName)
                .forEach(System.out::println);
    }

    @ShellMethod("Get product by id")
    void getProduct() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        long lookupId = scanner.nextLong();
        System.out.println(productService.getProductById(lookupId));
    }

    @ShellMethod("Add new product")
    void addProduct() {
        System.out.println(productService.addProduct(
                new Product(100, "Vacuum Cleaner", 350.50, "Very good", ELECTRONICS)
        ));
    }

    @ShellMethod("Delete product")
    void deleteProduct() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        System.out.println(productService.deleteProduct(lookupId));
    }
}
