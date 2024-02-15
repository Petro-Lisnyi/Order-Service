package edu.pil.orderservice.repositories;

import edu.pil.orderservice.domain.OrderHeader;
import edu.pil.orderservice.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveProduct() {
        Product savedProduct = productRepository.save(new Product());

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());

        var fetchedProduct = productRepository.getById(savedProduct.getId());

        assertNotNull(fetchedProduct);
        assertNotNull(fetchedProduct.getId());
        System.out.println(fetchedProduct.getCreatedDate().toLocalDateTime());
        assertNotNull(fetchedProduct.getCreatedDate());
        assertNotNull(fetchedProduct.getLastModifiedDate());
    }

    @Test
    void getCategoryTest() {
        var product = productRepository.findByDescription("PRODUCT1");

        assertNotNull(product);
        assertEquals(product.getCategories().size(), 2);
    }
}