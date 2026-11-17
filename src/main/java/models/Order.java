package models;

import java.util.List;
import java.util.Objects;

public record Order(
        String orderId,
        String customerName,
        List<String> products,
        String status) {

    public Order {
        Objects.requireNonNull(orderId, "Order ID cannot be null");
        Objects.requireNonNull(customerName, "Customer name cannot be null");
        Objects.requireNonNull(products, "Products list cannot be null");
        Objects.requireNonNull(status, "Status cannot be null");
    }
}