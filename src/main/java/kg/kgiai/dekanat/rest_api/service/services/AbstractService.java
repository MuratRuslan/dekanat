package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import javax.transaction.NotSupportedException;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<M, ID extends Serializable> implements Service<M, ID> {
    protected JpaRepository<M, ID> repository;

    public AbstractService(JpaRepository<M, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<M> getAll() {
        return repository.findAll();
    }

    @Override
    public M getById(ID id) {
        return repository.findOne(id);
    }

    @Override
    public void save(M object) {
        repository.save(object);
    }

    @Override
    public void save(Iterable<M> iterable) {
        repository.save(iterable);
    }

    @Override
    public void delete(Iterable<M> iterable) {
        repository.delete(iterable);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }
}
