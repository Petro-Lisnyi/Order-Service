package edu.pil.orderservice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

    @Test
    void testEquals() {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setCustomer("First");
        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setCustomer("First");
        assert (orderHeader1.equals(orderHeader2));
    }

}