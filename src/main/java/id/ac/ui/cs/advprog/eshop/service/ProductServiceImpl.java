package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private String tempId = "";
    private static int lastProductId = 0;

    @Override
    public Product create(Product product) {
        lastProductId++;
        product.setProductId(Integer.toString(lastProductId));
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public void delete(String productId) {
        productRepository.delete(productId);
    }

    @Override
    public void setId(String productId) {
        tempId = productId;
    }

    @Override
    public void edit(Product updatedProduct) {
        productRepository.edit(tempId, updatedProduct);
    }
}