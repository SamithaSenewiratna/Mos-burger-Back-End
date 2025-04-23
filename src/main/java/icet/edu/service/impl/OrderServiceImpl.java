package icet.edu.service.impl;

import icet.edu.dto.Order;

import icet.edu.dto.OrderDetail;
import icet.edu.entity.OrderDetailEntity;
import icet.edu.entity.OrderEntity;
import icet.edu.repository.OrderDetailRepository;
import icet.edu.repository.OrderRepository;
import icet.edu.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;
    final private OrderDetailRepository orderDetailRepository;
    final private ModelMapper mapper;


    @Override
    public String addOrder(Order order) {

        OrderEntity odr = new OrderEntity();
        odr.setCustomerId(order.getCustomerId());
        odr.setDate(LocalDate.now());
        odr.setTime(LocalTime.now());

        var details = order.getDetails().stream().map(d -> {
            OrderDetailEntity detail = new OrderDetailEntity();
            detail.setItemCode(d.getItemCode());
            detail.setQty(d.getQty());
            detail.setUnitPrice(d.getUnitPrice());
            detail.setOrder(odr);

            return detail;
        }).collect(Collectors.toList());

        odr.setDetails(details);
        orderRepository.save(odr);
        return "Order placed successfully!";

    }

    @Override
    public List<Order> getAllOrders() {

        System.out.println( orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));

        // Fetch all orders from the repository and map them to DTOs
        return orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }



    @Override
    public Order getOrderById(Long id) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);
        return orderOpt.map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public String updateOrder(Long id, Order order) {
        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setDate(LocalDate.now());
        existingOrder.setTime(LocalTime.now());

        existingOrder.getDetails().clear();
        List<OrderDetailEntity> updatedDetails = order.getDetails().stream().map(d -> {
            OrderDetailEntity detail = new OrderDetailEntity();
            detail.setItemCode(d.getItemCode());
            detail.setQty(d.getQty());
            detail.setUnitPrice(d.getUnitPrice());
            detail.setOrder(existingOrder);
            return detail;
        }).collect(Collectors.toList());

        existingOrder.setDetails(updatedDetails);
        orderRepository.save(existingOrder);
        return "Order updated successfully!";
    }

    @Override
    public String deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with ID: " + id);
        }
        orderRepository.deleteById(id);
        return "Order deleted successfully!";
    }

    private Order mapToDTO(OrderEntity entity) {
        Order dto = new Order();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setCustomerId(entity.getCustomerId());
        dto.setDetails(entity.getDetails().stream().map(d -> {
            OrderDetail detail = new OrderDetail();
            detail.setItemCode(d.getItemCode());
            detail.setQty(d.getQty());
            detail.setUnitPrice(d.getUnitPrice());
            return detail;
        }).collect(Collectors.toList()));
        return dto;
    }



}
