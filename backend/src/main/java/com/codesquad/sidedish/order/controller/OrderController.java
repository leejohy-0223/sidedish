package com.codesquad.sidedish.order.controller;

import com.codesquad.sidedish.order.dto.OrderItemDto;
import com.codesquad.sidedish.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "order", description = "반찬 주문 API")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "반찬 구매 성공")
    })
    @Operation(summary = "반찬 주문하기", description = "반찬을 원하는 수량만큼 구매합니다.")
    @PostMapping("/order")
    public void order(@RequestBody OrderItemDto orderItemDto, HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("userId");
        orderItemDto.setUserId(userId);
        orderService.order(orderItemDto);
    }
}
