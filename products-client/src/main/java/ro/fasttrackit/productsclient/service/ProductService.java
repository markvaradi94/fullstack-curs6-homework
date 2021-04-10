package ro.fasttrackit.productsclient.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.fasttrackit.productsclient.model.Product;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductService {
    private static final String PRODUCTS_URL = "http://localhost:8090/products";

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                PRODUCTS_URL,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {

                }
        ).getBody();
    }

    public List<Product> filterProductsByPrice(double maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(PRODUCTS_URL)
                .queryParam("maxPrice", maxPrice);
        return restTemplate.exchange(
                builder.toUriString(),
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> filterProductByCategory(String categoryName) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(PRODUCTS_URL)
                .queryParam("category", categoryName);
        return restTemplate.exchange(
                builder.toUriString(),
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getProductById(long productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(PRODUCTS_URL + "/" + productId, Product.class);
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(PRODUCTS_URL, newProduct, Product.class);
    }

    public Product deleteProduct(long productId) {
        Product productToDelete = getProductById(productId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(PRODUCTS_URL + "/" + productId, Product.class);
        return productToDelete;
    }
}
