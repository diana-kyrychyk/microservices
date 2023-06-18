package com.learn.order.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Order {

    Long id;
    List<String> userNamesMadeOrder;

}
