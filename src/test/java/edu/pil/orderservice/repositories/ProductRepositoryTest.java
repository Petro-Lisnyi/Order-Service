package edu.pil.orderservice.repositories;

import edu.pil.orderservice.domain.OrderHeader;
import edu.pil.orderservice.domain.Product;
import edu.pil.orderservice.domain.ProductStatus;
import edu.pil.orderservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackageClasses = {ProductService.class})
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

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
        var product = productRepository.findByDescription("PRODUCT1").get();

        assertNotNull(product);
        assertEquals(product.getCategories().size(), 2);
    }


    @Test
    void productQuantityTest() {

        var newProduct = new Product();
        newProduct.setProductStatus(ProductStatus.IN_STOCK);
        newProduct.setDescription("Quantity test");
        newProduct.setQuantityOnHand(5);

        var savedProduct = productService.saveProduct(newProduct);
        var updatedProduct = productService.updateQuantityOnHand(savedProduct.getId(), 20);

        assertNotNull(updatedProduct);
        assertEquals(updatedProduct.getQuantityOnHand(), 20);
    }
}