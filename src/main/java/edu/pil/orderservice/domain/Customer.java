package edu.pil.orderservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity{
    private String customerName;
    private String phone;
    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Set<OrderHeader> orderHeader;

    @Version
    private Integer version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getOrderHeader(), customer.getOrderHeader());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomerName(), getPhone(), getEmail(), getAddress());
    }
}
