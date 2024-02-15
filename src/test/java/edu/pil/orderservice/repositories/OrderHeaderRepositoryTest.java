package edu.pil.orderservice.repositories;

import edu.pil.orderservice.domain.OrderHeader;
import edu.pil.orderservice.domain.OrderLine;
import edu.pil.orderservice.domain.Product;
import edu.pil.orderservice.domain.ProductStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderRepositoryTest {
    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp(){
        var newProduct = new Product();
        newProduct.setDescription("New product");
        newProduct.setProductStatus(ProductStatus.NEW);
        product = productRepository.saveAndFlush(newProduct);
    }

    @Test
    void testSaveOrder() {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer("New Customer");
        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());

        OrderHeader fetchedOrder = orderHeaderRepository.getById(savedOrder.getId());

        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
        System.out.println(fetchedOrder.getCreatedDate().toLocalDateTime());
        assertNotNull(fetchedOrder.getCreatedDate());
        assertNotNull(fetchedOrder.getLastModifiedDate());
    }
    @Test
    void testSaveOrderWithLine() {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer("New Customer");

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(4);
        orderLine.setProduct(product);

        orderHeader.addOrderLine(orderLine);
        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(savedOrder.getOrderLines().size(), 1);
    }
}
