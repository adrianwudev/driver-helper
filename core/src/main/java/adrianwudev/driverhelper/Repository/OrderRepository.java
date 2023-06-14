package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;

public interface OrderRepository extends Repository<Order> {
    PageResult<Order> getByConditions(Order order, int page, int pageSize);
}
