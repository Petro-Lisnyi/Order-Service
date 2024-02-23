package edu.pil.orderservice.bootstrap;

import edu.pil.orderservice.domain.Customer;
import edu.pil.orderservice.domain.OrderHeader;
import edu.pil.orderservice.domain.Product;
import edu.pil.orderservice.domain.ProductStatus;
import edu.pil.orderservice.repositories.CustomerRepository;
import edu.pil.orderservice.repositories.OrderHeaderRepository;
import edu.pil.orderservice.services.ProductService;
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

    @Autowired
    private ProductService productService;


    @Override
    public void run(String... args) throws Exception {
//        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setCustomerName("Testing Version");
        var saverCustomer = customerRepository.save(customer);
        System.out.println("Saved customer version is " + saverCustomer.getVersion());

        saverCustomer.setCustomerName("Testing Version 2");
        var saverCustomer2 = customerRepository.save(saverCustomer);
        System.out.println("Saved customer version is " + saverCustomer2.getVersion());

        saverCustomer2.setCustomerName("Testing Version 3");
        var saverCustomer3 = customerRepository.save(saverCustomer2);
        System.out.println("Saved customer version is " + saverCustomer3.getVersion());

    //        customerRepository.delete(saverCustomer); // It won't work because the version isn't the same
        customerRepository.delete(saverCustomer3);

        updateProduct();
    }

    void updateProduct() {

        var newProduct = new Product();
        newProduct.setProductStatus(ProductStatus.IN_STOCK);
        newProduct.setDescription("Quantity test");
        newProduct.setQuantityOnHand(5);

        var savedProduct = productService.saveProduct(newProduct);
        var updatedProduct = productService.updateQuantityOnHand(savedProduct.getId(), 20);

        System.out.println("Updated quantity is " + updatedProduct.getQuantityOnHand());
    }
}
