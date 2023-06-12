package adrianwudev.driverhelper.Repository;

import java.util.List;

public interface Repository<T> {
    T get(int id);
    List<T> getAll (int page, int pageSize);

    boolean create(T object);
    boolean update(T object);
    boolean delete(int id);
}
