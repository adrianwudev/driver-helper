package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Model.Order;
import adrianwudev.driverhelper.Util.GsonAdaptor;
import adrianwudev.driverhelper.Util.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@Service
public class OrderRepository implements Repository<Order> {
    public static final Calendar tzUTC = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
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
    public List<Order> getAll(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean create(Order order) {
        String json = new GsonAdaptor<Order>().getJsonWithGsonAdaptor(order);
        log.info("Serialized Order object: " + json);

        try {
            int rowsAffected = dslContext
                    .execute("INSERT INTO public.orders( " +
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
