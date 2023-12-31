/*
 * This file is generated by jOOQ.
 */
package adrianwudev.driverhelper.Jooq.Dao.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String testName;

    public Test() {}

    public Test(Test value) {
        this.id = value.id;
        this.testName = value.testName;
    }

    public Test(
        Integer id,
        String testName
    ) {
        this.id = id;
        this.testName = testName;
    }

    /**
     * Getter for <code>public.test.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.test.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.test.test_name</code>.
     */
    public String getTestName() {
        return this.testName;
    }

    /**
     * Setter for <code>public.test.test_name</code>.
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Test other = (Test) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.testName == null) {
            if (other.testName != null)
                return false;
        }
        else if (!this.testName.equals(other.testName))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.testName == null) ? 0 : this.testName.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Test (");

        sb.append(id);
        sb.append(", ").append(testName);

        sb.append(")");
        return sb.toString();
    }
}
