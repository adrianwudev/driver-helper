package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Jooq.Dao.Tables;
import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Model.PageResult;
import adrianwudev.driverhelper.Model.SearchCondition;
import adrianwudev.driverhelper.Util.GsonAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderRepositoryImpl implements OrderRepository {
    private final DSLContext dslContext;

    public OrderRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
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
                String select = "SELECT order_id, city, district, address, order_time, pick_up_drop, pick_up_time," +
                        "       weekday, group_name, amount, distance, is_exception, " +
                        "       COUNT(*) OVER (PARTITION BY city, district, address, pick_up_time) AS repeat_count, " +
                        "       create_time, modify_time " +
                        "       FROM orders ";
                String pagination = " ORDER BY " +
                        " EXTRACT(EPOCH FROM ( order_time AT TIME ZONE 'UTC' - NOW() AT TIME ZONE 'UTC-8')) % (24 * 3600) ASC" +
                        "       , repeat_count DESC " +
                        "         LIMIT ? OFFSET ?";
                List<Order> orders = ctx.fetch(select + pagination, pageSize, (page - 1) * pageSize)
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
            throw e;
        }
    }

    @Override
    public boolean update(Order order) {
        try {
            return dslContext.transactionResult(configuration -> {
                DSLContext ctx = DSL.using(configuration);
                int rowsAffected = ctx.update(Tables.ORDERS)
                        .set(Tables.ORDERS.CITY, order.getCity())
                        .set(Tables.ORDERS.DISTRICT, order.getDistrict())
                        .set(Tables.ORDERS.ADDRESS, order.getAddress())
                        .set(Tables.ORDERS.ORDER_TIME, order.getOrderTime())
                        .set(Tables.ORDERS.PICK_UP_DROP, order.getPickUpDrop())
                        .set(Tables.ORDERS.PICK_UP_TIME, order.getPickUpTime())
                        .set(Tables.ORDERS.WEEKDAY, order.getWeekday())
                        .set(Tables.ORDERS.GROUP_NAME, order.getGroupName())
                        .set(Tables.ORDERS.AMOUNT, order.getAmount())
                        .set(Tables.ORDERS.DISTANCE, order.getDistance())
                        .set(Tables.ORDERS.IS_EXCEPTION, order.isException())
                        .set(Tables.ORDERS.REPEAT_COUNT, order.getRepeatCount())
                        .set(Tables.ORDERS.CREATE_TIME, order.getCreateTime())
                        .set(Tables.ORDERS.MODIFY_TIME, order.getModifyTime())
                        .where(Tables.ORDERS.ORDER_ID.eq(order.getOrderId()))
                        .execute();
                return rowsAffected > 0;
            });
        } catch (Exception e) {
            log.error("error: ", e);
            throw e;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            return dslContext.transactionResult(configuration -> {
                DSLContext ctx = DSL.using(configuration);
                int rowsAffected = ctx.delete(Tables.ORDERS)
                        .where(Tables.ORDERS.ORDER_ID.eq(id))
                        .execute();
                return rowsAffected > 0;
            });
        } catch (Exception e) {
            log.error("error: ", e);
            throw e;
        }
    }

    @Override
    public PageResult<Order> getByConditions(int page, int pageSize, SearchCondition condition) {
        try {
            return dslContext.transactionResult(configuration -> {
                DSLContext ctx = DSL.using(configuration);
                String cte =
                        """
                        WITH ranked_orders AS(
                            SELECT order_id, city, district, address, order_time, pick_up_drop, pick_up_time,
                             weekday, group_name, amount, distance, is_exception,
                             COUNT(*) OVER (PARTITION BY city, district, address, pick_up_time) AS repeat_count,
                             create_time, modify_time,
                             EXTRACT(EPOCH FROM ( order_time AT TIME ZONE 'UTC+8' - NOW() AT TIME ZONE 'UTC+8')) % (24 * 3600) AS order_time_diff
                             FROM orders
                        """;
                String cteCloseBracket= "\n) ";

                String select = """
                        
                        SELECT
                          order_id, city, district, address, order_time, pick_up_drop, pick_up_time,
                          weekday, group_name, amount, distance, is_exception, repeat_count, create_time, modify_time
                        FROM ranked_orders
                        """;

                StringBuilder where = new StringBuilder(" WHERE 1=1");
                List<Object> params = new ArrayList<>();
                if (!condition.getCity().isBlank()) {
                    where.append(" AND city = ?");
                    params.add(condition.getCity());
                }
                if (!condition.getDistrict().isBlank()) {
                    where.append(" AND district = ?");
                    params.add(condition.getDistrict());
                }
                if (!condition.getWeekDay().isBlank()) {
                    where.append(" AND weekday = ?");
                    params.add(condition.getWeekDay());
                }
                if (condition.getIsException() != null){
                    where.append(" AND is_exception = ?");
                    params.add(condition.getIsException());
                }

                String pagination =
                            """ 
                            ORDER BY
                                order_time_diff ASC,
                                repeat_count DESC
                                LIMIT ? OFFSET ? 
                            """;
                params.add(pageSize);
                params.add((page - 1) * pageSize);

                String sql = cte + where + cteCloseBracket + select + pagination;
                List<Order> orders = ctx.fetch(sql, params.toArray())
                        .into(Order.class);

                // Count Total
                String countSql = "SELECT COUNT(*) AS count FROM orders";
                countSql += where;

                // Delete pageSize, currentPage
                for (int i = 0; i < 2; i++) {
                    params.remove(params.size() - 1);
                }

                Record countRecord = ctx.fetchOne(countSql, params.toArray());

                Integer total = countRecord != null
                        ? countRecord.getValue(0, Integer.class) : 0;

                return new PageResult<>(total, page, pageSize, orders);
            });

        } catch (Exception e) {
            log.error("error: ", e);
            throw e;
        }
    }
}
