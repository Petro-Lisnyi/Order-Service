package edu.pil.orderservice.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderApproval extends BaseEntity{

    private String approvedBy;
}
