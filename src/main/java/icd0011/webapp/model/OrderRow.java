package icd0011.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class OrderRow implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Setter
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column
    @Getter
    @Setter
    private String itemName;

    @Column
    @Getter
    @Setter
    private Long quantity;

    @Column
    @Getter
    @Setter
    private Long price;

    public OrderRow() {
    }

    public OrderRow(String itemName, Long quantity, Long price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}
