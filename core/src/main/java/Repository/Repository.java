package Repository;

public interface Repository<T> {
    T get(int id);
    boolean create(T object);
    boolean update(T object);
    boolean delete(int id);
}
