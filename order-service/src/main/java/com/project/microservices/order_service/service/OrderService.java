package com.project.microservices.order_service.service;

import com.project.microservices.order_service.client.InventoryClient;
import com.project.microservices.order_service.dto.OrderDTO;
import com.project.microservices.order_service.model.Order;
import com.project.microservices.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderDTO orderDTO)
    {
        if (!inventoryClient.isInStock(orderDTO.skuCode(), orderDTO.quantity())){
            throw new RuntimeException("Insufficient stock");
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderDTO.skuCode());
        order.setPrice(orderDTO.price());
        order.setQuantity(orderDTO.quantity());
        orderRepository.save(order);
    }
}
