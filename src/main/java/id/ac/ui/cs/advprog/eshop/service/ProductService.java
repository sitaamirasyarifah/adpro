package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public void delete(String productId);
    public Product findProductById(String id);
    public void edit(Product product);
}