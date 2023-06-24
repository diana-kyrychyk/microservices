package com.learn.order.controller;

import com.learn.order.NotificationServiceFeignClient;
import com.learn.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private NotificationServiceFeignClient feignClient;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/{orderName}")
    public String doOrder(@PathVariable String orderName) {
        try {
            feignClient.sendNotification(String.format("Order '%s' was created.", orderName));
            return String.format("Order '%s' was created.", orderName);
        } catch (Exception e) {
            return "Error occurred: notification was not sent.";
        }
    }

    @GetMapping("/{id}")
    public Order orderById(@PathVariable long id) {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                "http://users-service/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        List<String> users = response.getBody();
        Order order = new Order();
        order.setId(id);
        order.setUserNamesMadeOrder(users);
        return order;
    }

}
