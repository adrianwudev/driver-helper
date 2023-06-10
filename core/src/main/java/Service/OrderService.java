package Service;

import Model.Order;

public interface OrderService {
    Order GetOrder(int orderId);
    Order[] GetOrders();
    boolean AddOrder();
    boolean UpdateOrder(Order order);
    boolean DeleteOrder(int orderId);
}
