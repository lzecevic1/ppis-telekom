package ba.unsa.etf.ppis.telekom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public abstract class BaseService<M, R extends JpaRepository<M, Long>> {

    @Autowired
    R repository;

    public Optional<M> getById(Long id) {
        return repository.findById(id);
    }

    public void save(M m) {
        repository.save(m);
    }

    public Collection<M> all() {
        return repository.findAll();
    }

    public Long count() {
        return repository.count();
    }

    public void delete(M m) {
        repository.delete(m);
    }

    public void deleteById(Long id) { repository.deleteById(id) ;}

    public void deleteAll() {
        repository.deleteAll();
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}
