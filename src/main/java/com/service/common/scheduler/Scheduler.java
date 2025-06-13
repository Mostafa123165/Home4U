package com.service.common.scheduler;

import com.service.business.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final OrderService orderService;

    @Scheduled(cron = "0 0 12 * * ?")
    public void updateOldOrdersToDelivered() {
        orderService.updateOldOrdersToDelivered();
    }
}
