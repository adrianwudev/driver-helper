package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Util.GsonAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Slf4j
@Service
public class OrderRepository implements Repository<Order> {
    private final DSLContext dslContext;

    public OrderRepository(Connection connection) {
        this.dslContext = DSL.using(connection, SQLDialect.POSTGRES);
    }


    @Override
    public Order get(int id) {
        Result<Record> result = dslContext.fetch("SELECT * FROM orders WHERE order_id = ?", id);

        if (!result.isNotEmpty())
            return null;
        return result.get(0).into(Order.class);
    }

    @Override
    public PageResult<Order> getAll(int page, int pageSize) {
        try {
            return dslContext.transactionResult(configuration -> {
                DSLContext ctx = DSL.using(configuration);
                String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
                List<Order> orders = ctx.fetch(sql, pageSize, (page - 1) * pageSize)
                        .into(Order.class);
                String countSql = "SELECT COUNT(*) AS count FROM orders";

                Record countRecord = ctx.fetchOne(countSql);
                Integer total = countRecord != null
                        ? countRecord.getValue(0, Integer.class) : 0;

                return new PageResult<>(total, page, pageSize, orders);
            });
        } catch (Exception e) {
            log.error("error: ", e);
            throw e;
        }
    }

    @Override
    public boolean create(Order order) {
        String json = new GsonAdaptor<Order>().getJsonWithGsonAdaptor(order);
        log.info("Serialized Order object: " + json);

        try {
            int rowsAffected = dslContext
                    .execute("INSERT INTO orders( " +
                                    " city, district, address " +
                                    ", order_time, pick_up_drop, pick_up_time" +
                                    ", weekday, group_name, amount, distance" +
                                    ", is_exception, repeat_count" +
                                    ", create_time, modify_time" +
                                    " )" +
                                    " VALUES ( " +
                                    "  ?, ?, ?" +
                                    ", ?, ?, ?" +
                                    ", ?, ?, ?, ?" +
                                    ", ?, ?" +
                                    ", ?, ?" +
                                    " );",

                            order.getCity(), order.getDistrict(), order.getAddress(),
                            order.getOrderTime(), order.getPickUpDrop(), order.getPickUpTime(),
                            order.getWeekday(), order.getGroupName(), order.getAmount(), order.getDistance(),
                            order.isException(), order.getRepeatCount(),
                            order.getCreateTime(), order.getModifyTime()
                    );

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
