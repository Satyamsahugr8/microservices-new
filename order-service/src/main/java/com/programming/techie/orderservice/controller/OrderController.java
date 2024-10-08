package com.programming.techie.orderservice.controller;

import com.programming.techie.orderservice.dto.OrderRequest;
import com.programming.techie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        orderService.placeOrder(orderRequest);
        return "order placed successfully";
    }
//
//    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
//        log.info("Cannot Place Order Executing Fallback logic");
//        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please order after some time!");
//    }

}
