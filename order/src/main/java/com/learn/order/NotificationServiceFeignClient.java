package com.learn.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationServiceFeignClient {

    @PostMapping("/sendNotification")
    void sendNotification(@RequestBody String notification);
}
