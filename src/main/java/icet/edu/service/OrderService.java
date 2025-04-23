package icet.edu.service;

import icet.edu.dto.Order;

import java.util.List;

public interface OrderService {


    String addOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    String updateOrder(Long id, Order order);
    String deleteOrder(Long id);



}
