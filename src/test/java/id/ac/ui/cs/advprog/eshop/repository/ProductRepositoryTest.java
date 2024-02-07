package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public final class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = createProduct("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Bambang", 100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertProductExists(productIterator, product);
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = createProduct("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Bambang", 100);
        Product product2 = createProduct("a0f9de46-90b1-437d-a0bf-d0821dde9096", "Sampo Cap Usep", 50);

        productRepository.create(product1);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertProductExists(productIterator, product1);
        assertProductExists(productIterator, product2);
    }

    @Test
    void testEdit() {
        Product product = createProduct("1", "Sampo Cap Bambang", 100);
        productRepository.create(product);

        Product updatedProduct = createProduct("1", "Sampo Cap Usep", 50);

        productRepository.edit(product.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertProductExists(productIterator, updatedProduct);
    }

    @Test
    void testDelete() {
        Product product = createProduct("1", "Sampo Cap Bambang", 100);
        productRepository.create(product);

        productRepository.delete(product.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditandDelete() {
        Product product = createProduct("1", "Sampo Cap Bambang", 100);
        productRepository.create(product);

        Product updatedProduct = createProduct("1", "Sampo Cap Usep", 50);

        productRepository.edit(product.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertProductExists(productIterator, updatedProduct);

        productRepository.delete("1");

        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditMultiple() {
        Product product1 = createProduct("1", "Sampo Cap Bambang", 100);
        Product product2 = createProduct("2", "Sampo Cap Bango", 50);

        productRepository.create(product1);
        productRepository.create(product2);

        Product updatedProduct1 = createProduct("1", "Sampo Cap Usep", 25);
        Product updatedProduct2 = createProduct("2", "Sampo Cap Meong", 75);

        productRepository.edit(product1.getProductId(), updatedProduct1);
        productRepository.edit(product2.getProductId(), updatedProduct2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertProductExists(productIterator, updatedProduct1);
        assertProductExists(productIterator, updatedProduct2);
    }

    @Test
    void testDeleteMultiple() {
        Product product1 = createProduct("1", "Sampo Cap Bambang", 100);
        Product product2 = createProduct("2", "Sampo Cap Bango", 50);

        productRepository.create(product1);
        productRepository.create(product2);

        productRepository.delete(product1.getProductId());
        productRepository.delete(product2.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    private Product createProduct(String productId, String productName, int productQuantity) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductQuantity(productQuantity);
        return product;
    }

    private void assertProductExists(Iterator<Product> productIterator, Product product) {
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
}
