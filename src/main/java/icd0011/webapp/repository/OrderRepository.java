package icd0011.webapp.repository;

import icd0011.webapp.model.Order;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderRepository extends Repository<Order, Long> {
    Order findById(Long id);
    List<Order> findAll();
    Order save(Order order);
    void deleteById(Long id);
}
