package edu.pil.orderservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@AttributeOverrides({
        @AttributeOverride(
                name = "shippingAddress.address",
                column = @Column(name = "shipping_address")
        ),
        @AttributeOverride(
                name = "shippingAddress.city",
                column = @Column(name = "shipping_city")
        ),
        @AttributeOverride(
                name = "shippingAddress.state",
                column = @Column(name = "shipping_state")
        ),
        @AttributeOverride(
                name = "shippingAddress.zipCode",
                column = @Column(name = "shipping_zip_code")
        ),
        @AttributeOverride(
                name = "billToAddress.address",
                column = @Column(name = "bill_to_address")
        ),
        @AttributeOverride(
                name = "billToAddress.city",
                column = @Column(name = "bill_to_city")
        ),
        @AttributeOverride(
                name = "billToAddress.state",
                column = @Column(name = "bill_to_state")
        ),
        @AttributeOverride(
                name = "billToAddress.zipCode",
                column = @Column(name = "bill_to_zip_code")
        )
})
public class OrderHeader extends BaseEntity{
    private String customer;

    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billToAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderHeader that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getShippingAddress(), that.getShippingAddress()) && Objects.equals(getBillToAddress(), that.getBillToAddress()) && getOrderStatus() == that.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomer(), getShippingAddress(), getBillToAddress(), getOrderStatus());
    }
}
