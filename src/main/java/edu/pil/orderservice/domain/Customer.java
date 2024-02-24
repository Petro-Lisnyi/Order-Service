package edu.pil.orderservice.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity{

    @Size(max = 50)
    private String customerName;

    @Size(max = 20)
    private String phone;

    @Email
    @Size(max = 255)
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
