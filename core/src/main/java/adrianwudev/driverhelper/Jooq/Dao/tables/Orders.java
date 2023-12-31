/*
 * This file is generated by jOOQ.
 */
package adrianwudev.driverhelper.Jooq.Dao.tables;


import adrianwudev.driverhelper.Jooq.Dao.Indexes;
import adrianwudev.driverhelper.Jooq.Dao.Keys;
import adrianwudev.driverhelper.Jooq.Dao.Public;
import adrianwudev.driverhelper.Jooq.Dao.tables.records.OrdersRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function15;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row15;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Orders extends TableImpl<OrdersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.orders</code>
     */
    public static final Orders ORDERS = new Orders();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrdersRecord> getRecordType() {
        return OrdersRecord.class;
    }

    /**
     * The column <code>public.orders.order_id</code>.
     */
    public final TableField<OrdersRecord, Integer> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.orders.city</code>.
     */
    public final TableField<OrdersRecord, String> CITY = createField(DSL.name("city"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.district</code>.
     */
    public final TableField<OrdersRecord, String> DISTRICT = createField(DSL.name("district"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.address</code>.
     */
    public final TableField<OrdersRecord, String> ADDRESS = createField(DSL.name("address"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.order_time</code>.
     */
    public final TableField<OrdersRecord, LocalDateTime> ORDER_TIME = createField(DSL.name("order_time"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.orders.pick_up_drop</code>.
     */
    public final TableField<OrdersRecord, String> PICK_UP_DROP = createField(DSL.name("pick_up_drop"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.pick_up_time</code>.
     */
    public final TableField<OrdersRecord, LocalDateTime> PICK_UP_TIME = createField(DSL.name("pick_up_time"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.orders.weekday</code>.
     */
    public final TableField<OrdersRecord, String> WEEKDAY = createField(DSL.name("weekday"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.group_name</code>.
     */
    public final TableField<OrdersRecord, String> GROUP_NAME = createField(DSL.name("group_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.orders.amount</code>.
     */
    public final TableField<OrdersRecord, Double> AMOUNT = createField(DSL.name("amount"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.orders.distance</code>.
     */
    public final TableField<OrdersRecord, Double> DISTANCE = createField(DSL.name("distance"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.orders.is_exception</code>.
     */
    public final TableField<OrdersRecord, Boolean> IS_EXCEPTION = createField(DSL.name("is_exception"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.orders.repeat_count</code>.
     */
    public final TableField<OrdersRecord, Integer> REPEAT_COUNT = createField(DSL.name("repeat_count"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.orders.create_time</code>.
     */
    public final TableField<OrdersRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.orders.modify_time</code>.
     */
    public final TableField<OrdersRecord, LocalDateTime> MODIFY_TIME = createField(DSL.name("modify_time"), SQLDataType.LOCALDATETIME(6), this, "");

    private Orders(Name alias, Table<OrdersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Orders(Name alias, Table<OrdersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.orders</code> table reference
     */
    public Orders(String alias) {
        this(DSL.name(alias), ORDERS);
    }

    /**
     * Create an aliased <code>public.orders</code> table reference
     */
    public Orders(Name alias) {
        this(alias, ORDERS);
    }

    /**
     * Create a <code>public.orders</code> table reference
     */
    public Orders() {
        this(DSL.name("orders"), null);
    }

    public <O extends Record> Orders(Table<O> child, ForeignKey<O, OrdersRecord> key) {
        super(child, key, ORDERS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_ORDERS_ISEXCEPTION, Indexes.IDX_ORDERS_WEEKDAY, Indexes.IDX_ORDERS_WEEKDAY_ISEXCEPTION);
    }

    @Override
    public Identity<OrdersRecord, Integer> getIdentity() {
        return (Identity<OrdersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrdersRecord> getPrimaryKey() {
        return Keys.ORDERS_PKEY;
    }

    @Override
    public Orders as(String alias) {
        return new Orders(DSL.name(alias), this);
    }

    @Override
    public Orders as(Name alias) {
        return new Orders(alias, this);
    }

    @Override
    public Orders as(Table<?> alias) {
        return new Orders(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Orders rename(String name) {
        return new Orders(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Orders rename(Name name) {
        return new Orders(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Orders rename(Table<?> name) {
        return new Orders(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<Integer, String, String, String, LocalDateTime, String, LocalDateTime, String, String, Double, Double, Boolean, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function15<? super Integer, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? super String, ? super String, ? super Double, ? super Double, ? super Boolean, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function15<? super Integer, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? super String, ? super String, ? super Double, ? super Double, ? super Boolean, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
