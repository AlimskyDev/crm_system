package kz.bitlab.crm_system.services;

import kz.bitlab.crm_system.models.OrderModel;

import java.util.List;

public interface OrderService {
    List<OrderModel> getOrders();
    List<OrderModel> getNewOrders();
    List<OrderModel> getOldOrders();
    OrderModel getOrderModelById(Long id);

    void addNewOrder(OrderModel orderModel);

    OrderModel changeAppService(Long id);

    void deleteOrder(Long id);
}
