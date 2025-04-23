package icet.edu.controller;

import icet.edu.dto.Order;
import icet.edu.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {


    private final OrderService service;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        return service.addOrder(order);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }


    @GetMapping("getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }


    @PutMapping("update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return ResponseEntity.ok(service.updateOrder(id, order));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteOrder(id));
    }



}
