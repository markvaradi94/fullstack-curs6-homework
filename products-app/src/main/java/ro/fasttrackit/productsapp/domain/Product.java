package ro.fasttrackit.productsapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.fasttrackit.productsapp.enums.ProductCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    Long id;

    String name;

    Double price;

    String description;

    ProductCategory productCategory;

    public Product(String name, Double price, String description, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productCategory = productCategory;
    }
}
