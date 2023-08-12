package adrianwudev.driverhelper.Controller;

import adrianwudev.driverhelper.Codes.StatusCode;
import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Model.SearchCondition;
import adrianwudev.driverhelper.Response.JsonResponse;
import adrianwudev.driverhelper.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/conditions")
    public JsonResponse<PageResult<Order>> getOrdersByConditions(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int pageSize,
            @RequestParam String city, @RequestParam String district, @RequestParam String weekDay,
            @RequestParam(required = false) Boolean isException,
            @RequestParam(required = false) String time) {

        SearchCondition condition = new SearchCondition(city.trim(), district, weekDay, isException, time);
        return new JsonResponse<>(StatusCode.OK.getCode(), orderService.GetOrdersByConditions(page, pageSize, condition));
    }

    @PostMapping
    public JsonResponse<Object> addOrder(@RequestBody Order order) {
        if (!orderService.AddOrder(order))
            return new JsonResponse<>(StatusCode.UNKNOWN.getCode());

        return new JsonResponse<>(StatusCode.OK.getCode());
    }

    @PutMapping
    public JsonResponse<Object> updateOrder(@RequestBody Order order) {
        if (!orderService.UpdateOrder(order))
            return new JsonResponse<>(StatusCode.UNKNOWN.getCode());

        return new JsonResponse<>(StatusCode.OK.getCode());
    }

    @DeleteMapping("/{orderId}")
    public JsonResponse<Object> deleteOrder(@PathVariable int orderId) {
        if (!orderService.DeleteOrder(orderId))
            return new JsonResponse<>(StatusCode.UNKNOWN.getCode());

        return new JsonResponse<>(StatusCode.OK.getCode());
    }
}
