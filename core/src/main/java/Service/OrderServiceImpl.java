package Service;

import Model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public Order GetOrder(int orderId) {
        return null;
    }

    @Override
    public Order[] GetOrders() {
        return new Order[0];
    }

    @Override
    public boolean AddOrder() {
        return false;
    }

    @Override
    public boolean UpdateOrder(Order order) {
        return false;
    }

    @Override
    public boolean DeleteOrder(int orderId) {
        return false;
    }
}
