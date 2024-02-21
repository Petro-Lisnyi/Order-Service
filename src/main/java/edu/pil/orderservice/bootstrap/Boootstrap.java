package edu.pil.orderservice.bootstrap;

import edu.pil.orderservice.domain.Customer;
import edu.pil.orderservice.domain.OrderHeader;
import edu.pil.orderservice.repositories.CustomerRepository;
import edu.pil.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class Boootstrap implements CommandLineRunner {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private  BootstrapOrderService bootstrapOrderService;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setCustomerName("Testing Version");
        var saverCustomer = customerRepository.save(customer);

        System.out.println("Saved customer version is " + saverCustomer.getVersion());

        customerRepository.deleteById(saverCustomer.getId());
    }
}
