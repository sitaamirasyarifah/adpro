package id.ac.ui.cs.advprog.eshop.model;


import java.util.List;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@@ -13,13 +14,39 @@ public class Order {
    List<Product> products;
    Long orderTime;
    String author;

    String status;

    public Order(String id, List<Product> products, Long orderTime, String author) {
        this(id, products, orderTime, author);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (OrderStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
    }
}