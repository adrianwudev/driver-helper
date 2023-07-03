package adrianwudev.driverhelper.Service;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Model.SearchCondition;

public interface OrderService {
    Order GetOrder(int orderId);
    PageResult<Order> GetOrders(int page, int pageSize);
    PageResult<Order> GetOrdersByConditions(int page, int pageSize, SearchCondition condition);

    boolean AddOrder(Order order);
    boolean UpdateOrder(Order order);
    boolean DeleteOrder(int orderId);
}
