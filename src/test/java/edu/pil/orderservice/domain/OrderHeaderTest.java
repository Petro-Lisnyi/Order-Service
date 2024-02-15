package edu.pil.orderservice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

    @Test
    void testEquals() {
        OrderHeader orderHeader1 = new OrderHeader();
        Customer customer = new Customer();
        customer.setCustomerName("First");
        orderHeader1.setCustomer(customer);
        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setCustomer(customer);
        assert (orderHeader1.equals(orderHeader2));
    }

}