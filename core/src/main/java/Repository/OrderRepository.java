package Repository;

import Model.Order;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

@Slf4j
public class OrderRepository implements Repository<Order> {
    private DSLContext dslContext;

    public OrderRepository(Connection connection) {
        this.dslContext = DSL.using(connection, SQLDialect.POSTGRES);
    }
    @Override
    public Order get(int id) {
        return null;
    }

    @Override
    public boolean create(Order order) {
        try {
            int rowsAffected = dslContext
                    .execute("INSERT INTO orders (order_id, city, district, address, order_time, pick_up_drop, pick_up_time, weekday, group, amount, distance, is_exception, repeat_count) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            order.getOrderId(),
                            order.getCity(),
                            order.getDistrict(),
                            order.getAddress(),
                            order.getOrderTime(),
                            order.getPickUpDrop(),
                            order.getPickUpTime(),
                            order.getWeekday(),
                            order.getGroup(),
                            order.getAmount(),
                            order.getDistance(),
                            order.isException(),
                            order.getRepeatCount());

            return rowsAffected > 0;
        } catch (Exception e) {
            log.error("exception", e);
            return false;
        }
    }

    @Override
    public boolean update(Order object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
