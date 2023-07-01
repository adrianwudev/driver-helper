package adrianwudev.driverhelper.Repository;

import adrianwudev.driverhelper.Model.PageResult;
import org.jooq.DSLContext;

public interface Repository<T> {
    T get(int id);

    PageResult<T> getAll(int page, int pageSize);

    boolean create(T object);

    boolean update(T object);

    boolean delete(int id);
    DSLContext getDSLContext();
}
