package edu.pil.orderservice.repositories;

import edu.pil.orderservice.domain.Customer;
import edu.pil.orderservice.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.IntSummaryStatistics;
import java.util.List;

public interface OrderHeaderRepository  extends JpaRepository<OrderHeader, Long> {
    List<OrderHeader> findAllByCustomer(Customer customer);
}
