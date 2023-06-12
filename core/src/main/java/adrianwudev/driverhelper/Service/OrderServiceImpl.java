package adrianwudev.driverhelper.Service;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Qualifier.DefaultPage;
import adrianwudev.driverhelper.Qualifier.DefaultPageSize;
import adrianwudev.driverhelper.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{
    private final int defaultPage;
    private final int defaultPageSize;
    private final OrderRepository repository;
    @Autowired
    public OrderServiceImpl(OrderRepository repository,
                            @DefaultPage int defaultPage, @DefaultPageSize int defaultPageSize){
        this.repository = repository;
        this.defaultPage = defaultPage;
        this.defaultPageSize = defaultPageSize;
    }

    @Override
    public Order GetOrder(int orderId) {
        return repository.get(orderId);
    }

    @Override
    public List<Order> GetOrders(int page, int pageSize) {
        if (page <= 0) page = defaultPage;
        if (pageSize <= 0) pageSize = defaultPageSize;
        return repository.getAll(page, pageSize);
    }

    @Override
    public boolean AddOrder(Order order) {
        return repository.create(order);
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
