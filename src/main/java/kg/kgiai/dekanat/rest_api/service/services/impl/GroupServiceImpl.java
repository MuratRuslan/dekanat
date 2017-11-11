package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.repository.GruppaRepository;
import kg.kgiai.dekanat.rest_api.service.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GruppaRepository gruppaRepository;

    @Override
    public List<Gruppa> getAll() {
        return gruppaRepository.findAll();
    }

    @Override
    public Gruppa getById(Long id) {
        return gruppaRepository.findOne(id);
    }

    @Override
    public Gruppa getByName(String name) {
        return gruppaRepository.findByName(name);
    }

    @Override
    public void save(Gruppa object) {
        gruppaRepository.save(object);
    }

    @Override
    public void save(Iterable<Gruppa> iterable) {
        gruppaRepository.save(iterable);
    }

    @Override
    public void delete(Iterable<Gruppa> iterable) {
        gruppaRepository.delete(iterable);
    }

    @Override
    public void delete(Long id) {
        gruppaRepository.delete(id);
    }
}
