package ro.fasttrackit.productsclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.fasttrackit.productsclient.enums.ProductCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private ProductCategory productCategory;
}
