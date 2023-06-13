package adrianwudev.driverhelper.Service;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;

public interface OrderService {
    Order GetOrder(int orderId);
    PageResult<Order> GetOrders(int page, int pageSize);

    boolean AddOrder(Order order);
    boolean UpdateOrder(Order order);
    boolean DeleteOrder(int orderId);
}
