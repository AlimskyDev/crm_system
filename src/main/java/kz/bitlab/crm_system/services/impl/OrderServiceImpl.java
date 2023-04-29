package kz.bitlab.crm_system.services.impl;

import kz.bitlab.crm_system.models.OrderModel;
import kz.bitlab.crm_system.repositories.OrderRepository;
import kz.bitlab.crm_system.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getOrders(){
        return orderRepository.findAll();
    }

    public OrderModel getOrderModelById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<OrderModel> getNewOrders() {
        return orderRepository.findAll()
                .stream()
                .filter(order -> !order.isHandled())
                .collect(Collectors.toList());
    }
    public List<OrderModel> getOldOrders() {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.isHandled())
                .collect(Collectors.toList());
    }

    public void addNewOrder(OrderModel orderModel) {
        orderModel.setHandled(false);
        orderRepository.save(orderModel);
    }

    public OrderModel changeAppService(Long id) {
        OrderModel orderModel = orderRepository.findById(id).orElse(null);
        if (orderModel != null) {
            orderModel.setHandled(true);
            try {
                orderRepository.save(orderModel);
            } catch (Exception e) {
                // Handle the exception, e.g. log the error message
                System.out.println("Error updating order with id " + id + ": " + e.getMessage());
            }
        }
        return orderModel;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
