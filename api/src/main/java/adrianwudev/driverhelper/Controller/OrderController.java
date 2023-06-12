package adrianwudev.driverhelper.Controller;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderservice){
        this.orderService = orderservice;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return orderService.GetOrder(orderId);
    }

    @GetMapping
    public List<Order> getOrders(@RequestParam int page, @RequestParam int pageSize) {
        return orderService.GetOrders(page, pageSize);
    }

    @PostMapping
    public boolean addOrder(@RequestBody Order order) {
        return orderService.AddOrder(order);
    }

    @PutMapping("/{orderId}")
    public boolean updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        order.setOrderId(orderId);
        return orderService.UpdateOrder(order);
    }
}
