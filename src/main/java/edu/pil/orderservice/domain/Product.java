package edu.pil.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDescription(), product.getDescription()) && getProductStatus() == product.getProductStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDescription(), getProductStatus());
    }
}
