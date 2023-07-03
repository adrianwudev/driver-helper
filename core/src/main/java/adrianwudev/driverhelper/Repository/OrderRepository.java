package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Model.SearchCondition;

public interface OrderRepository extends Repository<Order> {
    PageResult<Order> getByConditions(int page, int pageSize, SearchCondition condition);
}
