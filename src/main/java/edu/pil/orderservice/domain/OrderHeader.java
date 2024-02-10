package edu.pil.orderservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;
}
