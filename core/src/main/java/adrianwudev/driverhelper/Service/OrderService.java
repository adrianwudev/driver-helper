package adrianwudev.driverhelper.Service;

import adrianwudev.driverhelper.Model.Order;

import java.util.List;

public interface OrderService {
    Order GetOrder(int orderId);
    List<Order> GetOrders(int page, int pageSize);

    boolean AddOrder(Order order);
    boolean UpdateOrder(Order order);
    boolean DeleteOrder(int orderId);
}
