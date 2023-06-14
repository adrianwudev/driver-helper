/*
 * This file is generated by jOOQ.
 */
package adrianwudev.driverhelper.Jooq.Dao.tables.records;


import adrianwudev.driverhelper.Jooq.Dao.tables.Test;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestRecord extends UpdatableRecordImpl<TestRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.test.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.test.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.test.test_name</code>.
     */
    public void setTestName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.test.test_name</code>.
     */
    public String getTestName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Test.TEST.ID;
    }

    @Override
    public Field<String> field2() {
        return Test.TEST.TEST_NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTestName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTestName();
    }

    @Override
    public TestRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TestRecord value2(String value) {
        setTestName(value);
        return this;
    }

    @Override
    public TestRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestRecord
     */
    public TestRecord() {
        super(Test.TEST);
    }

    /**
     * Create a detached, initialised TestRecord
     */
    public TestRecord(Integer id, String testName) {
        super(Test.TEST);

        setId(id);
        setTestName(testName);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised TestRecord
     */
    public TestRecord(adrianwudev.driverhelper.Jooq.Dao.tables.pojos.Test value) {
        super(Test.TEST);

        if (value != null) {
            setId(value.getId());
            setTestName(value.getTestName());
            resetChangedOnNotNull();
        }
    }
}