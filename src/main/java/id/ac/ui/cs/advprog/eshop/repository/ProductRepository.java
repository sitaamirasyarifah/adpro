package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void delete(Product product) {
        productData.remove(product);
    }

    public List<Product> getProductData() {
        return productData;
    }

    public void edit(Product editedProduct) {
        for (Product product : productData) {
            if (product.getProductId().equals(editedProduct.getProductId())) {
                product.setProductName(editedProduct.getProductName());
                product.setProductQuantity(editedProduct.getProductQuantity());
            }
        }
    }
}