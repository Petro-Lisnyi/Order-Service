package edu.pil.orderservice.bootstrap;

import edu.pil.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BootstrapOrderService {


    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData() {
        var orderHeader = orderHeaderRepository.findById(131L).get();

        orderHeader.getOrderLines().forEach(orderLine -> {
            System.out.println(orderLine.getProduct().getDescription());

            orderLine.getProduct().getCategories().forEach(category -> {
                System.out.println(category.getDescription());
            });
        });
    }
}
