package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;
import java.util.List;

public interface ProductRepositoryInterface {
    public Product create(Product product);
    public void delete(Product product);
    public void edit(Product product);
    public Iterator<Product> findAll();
    public List<Product> getProductData();
}