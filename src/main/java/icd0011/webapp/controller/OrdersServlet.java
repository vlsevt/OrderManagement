package icd0011.webapp.controller;

import icd0011.webapp.ValidationError;
import icd0011.webapp.ValidationErrors;
import icd0011.webapp.model.Order;
import icd0011.webapp.model.OrderRow;
import icd0011.webapp.repository.OrderRepository;
import icd0011.webapp.repository.OrderRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersServlet {

    private final OrderRepository repository;
    private final OrderRowRepository orderRowRepository;

    @Autowired
    public OrdersServlet(OrderRepository repository, OrderRowRepository orderRowRepository) {
        this.repository = repository;
        this.orderRowRepository = orderRowRepository;
    }

    @GetMapping
    /* default */ List<Order> getAll() {
        return repository.findAll();
    }

    @GetMapping(params="id")
    /* default */ Order getOne(@RequestParam Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Order order) {
        if (order.getOrderNumber().length() < 2) {
            ValidationErrors validationErrors = new ValidationErrors();
            validationErrors.setErrors(Collections.singletonList(new ValidationError("too_short_number")));

            return ResponseEntity.badRequest().body(validationErrors);
        }

        Order savedOrder = repository.save(order);
        for (OrderRow orderRow : order.getOrderRows()) {
            orderRow.setOrder(savedOrder);
            orderRowRepository.save(orderRow);
        }
        return ResponseEntity.ok(savedOrder);
    }

    @DeleteMapping
    /* default */ void deleteById(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
