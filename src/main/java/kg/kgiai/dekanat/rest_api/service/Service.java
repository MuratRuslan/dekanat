package kg.kgiai.dekanat.rest_api.service;

import javax.transaction.NotSupportedException;
import java.util.List;

@org.springframework.stereotype.Service
public interface Service<T, ID> {
    List<T> getAll();

    T getById(ID id);

    T getByName(String name) throws NotSupportedException;

    void save(T object);

    void save(Iterable<T> iterable);

    void delete(Iterable<T> iterable);

    void delete(ID id);
}
