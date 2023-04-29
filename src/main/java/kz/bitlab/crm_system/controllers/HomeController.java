package kz.bitlab.crm_system.controllers;

import kz.bitlab.crm_system.models.OrderModel;
import kz.bitlab.crm_system.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String homePage(Model model){
        List<OrderModel> orderModels = orderService.getOrders();
        model.addAttribute("orderModels", orderModels);
        return "home";
    }
    @GetMapping("/newOrders")
    public String onlyNewOrders(Model model) {
        List<OrderModel> newOrderModels = orderService.getNewOrders();
        model.addAttribute("orderModels", newOrderModels);
        return "home";
    }
    @GetMapping("/oldOrders")
    public String onlyOldOrders(Model model) {
        List<OrderModel> oldOrderModels = orderService.getOldOrders();
        model.addAttribute("orderModels", oldOrderModels);
        return "home";
    }


    @GetMapping("/details/{id}")
    public String orderDetails(@PathVariable Long id, Model model) {
        OrderModel orderModel = orderService.getOrderModelById(id);
        if (id!=null) {
            model.addAttribute("order", orderModel);
            return "details";
        }
        return "home";
    }


    @PostMapping("/addNewOrder")
    public String addNewOrder(OrderModel orderModel) {
        orderService.addNewOrder(orderModel);
        return "redirect:/";
    }

    @GetMapping("/details/proc/{id}")
    public String changeApp(@PathVariable Long id, Model model) {
        orderService.changeAppService(id);
        OrderModel orderModel = orderService.getOrderModelById(id);
        model.addAttribute("order", orderModel);
        return ("details");
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam (name = "id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:/";
    }
}