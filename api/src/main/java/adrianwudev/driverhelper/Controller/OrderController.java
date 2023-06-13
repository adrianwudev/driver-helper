package adrianwudev.driverhelper.Controller;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Response.JsonResponse;
import adrianwudev.driverhelper.Service.OrderService;
import adrianwudev.driverhelper.Codes.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderservice) {
        this.orderService = orderservice;
    }

    @GetMapping("/{orderId}")
    public JsonResponse<Order> getOrder(@PathVariable int orderId) {
        return new JsonResponse<>(StatusCode.OK.getCode(), orderService.GetOrder(orderId));
    }

    @GetMapping
    public JsonResponse<PageResult<Order>> getOrders(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int pageSize) {
        return new JsonResponse<>(StatusCode.OK.getCode(), orderService.GetOrders(page, pageSize));
    }

    @PostMapping
    public JsonResponse<Object> addOrder(@RequestBody Order order) {
        if (orderService.AddOrder(order))
            return new JsonResponse<>(StatusCode.OK.getCode());
        else
            return new JsonResponse<>(StatusCode.UNKNOWN.getCode());
    }

    @PutMapping("/{orderId}")
    public boolean updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        order.setOrderId(orderId);
        return orderService.UpdateOrder(order);
    }
}
