package adrianwudev.driverhelper.Service;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Qualifier.DefaultPage;
import adrianwudev.driverhelper.Qualifier.DefaultPageSize;
import adrianwudev.driverhelper.Repository.OrderRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{
    private final int defaultPage;
    private final int defaultPageSize;
    private final OrderRepositoryImpl repository;
    @Autowired
    public OrderServiceImpl(OrderRepositoryImpl repository,
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
    public PageResult<Order> GetOrders(int page, int pageSize) {
        if (page <= 0) page = defaultPage;
        if (pageSize <= 0) pageSize = defaultPageSize;
        return repository.getAll(page, pageSize);
    }

    @Override
    public boolean AddOrder(Order order) {
        order.setWeekday(LocalDate.now().getDayOfWeek().toString());
        order.setCreateTime(LocalDateTime.now());
        order.setModifyTime(LocalDateTime.now());
        return repository.create(order);
    }

    @Override
    public boolean UpdateOrder(Order order) {
        order.setModifyTime(LocalDateTime.now());
        return repository.update(order);
    }

    @Override
    public boolean DeleteOrder(int orderId) {
        return repository.delete(orderId);
    }
}
