package edu.pil.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    private OrderHeader orderHeader;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLine orderLine)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getQuantityOrdered(), orderLine.getQuantityOrdered()) && Objects.equals(getOrderHeader(), orderLine.getOrderHeader());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQuantityOrdered(), getOrderHeader());
    }
}
