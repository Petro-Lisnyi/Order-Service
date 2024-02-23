package edu.pil.orderservice.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity{

    @Length(max = 50)
    private String customerName;

    @Length(max = 20)
    private String phone;
    private String email;

    @Valid
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
