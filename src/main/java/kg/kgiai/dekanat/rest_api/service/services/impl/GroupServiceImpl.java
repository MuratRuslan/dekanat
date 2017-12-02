package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.repository.GruppaRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl extends AbstractService<Gruppa, Long> implements GroupService {

    @Autowired
    public GroupServiceImpl(JpaRepository<Gruppa, Long> repository) {
        super(repository);
    }

    @Override
    public Gruppa getByName(String name) {
        return ((GruppaRepository) repository).findByName(name);
    }
}
