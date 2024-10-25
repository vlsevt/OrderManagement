package icd0011.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    private String orderNumber;

    @Column
    @Getter
    @Setter
    @OneToMany(mappedBy = "order")
    private List<OrderRow> orderRows = new ArrayList<>();

    protected Order() {

    }

    public Order(Long id, String orderNumber) {
        this.id = id;
        this.orderNumber = orderNumber;
    }
}
