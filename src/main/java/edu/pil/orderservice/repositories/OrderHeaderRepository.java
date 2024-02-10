package edu.pil.orderservice.repositories;

import edu.pil.orderservice.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository  extends JpaRepository<OrderHeader, Long> {
}
