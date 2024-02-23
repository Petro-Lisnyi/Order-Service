package edu.pil.orderservice.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Embeddable
@Setter
@Getter
public class Address {

    private String address;

    @Length(max = 30)
    private String city;
    private String state;
    private String zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address1)) return false;
        return Objects.equals(getAddress(), address1.getAddress()) && Objects.equals(getCity(), address1.getCity()) && Objects.equals(getState(), address1.getState()) && Objects.equals(getZipCode(), address1.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getCity(), getState(), getZipCode());
    }
}
