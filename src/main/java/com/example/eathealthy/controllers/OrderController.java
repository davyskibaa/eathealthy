package com.example.eathealthy.controllers;

import com.example.eathealthy.dto.OrderDTO;
import com.example.eathealthy.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute("delivery")
    public OrderDTO orderDTO(){
        return new OrderDTO();
    }

    @GetMapping
    public String showBookingPage(){
        return "delivery";
    }

    @PostMapping
    public String makeOrder(@ModelAttribute("delivery")OrderDTO orderDTO){
        orderService.save(orderDTO);
        return "redirect:/delivery?success";
    }
}
