package icd0011.webapp.repository;

import icd0011.webapp.model.OrderRow;
import org.springframework.data.repository.Repository;

public interface OrderRowRepository extends Repository<OrderRow, Long> {
    void save(OrderRow orderRow);
}
