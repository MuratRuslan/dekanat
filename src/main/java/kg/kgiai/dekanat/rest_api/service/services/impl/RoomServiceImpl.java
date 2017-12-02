package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Room;
import kg.kgiai.dekanat.rest_api.repository.RoomRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends AbstractService<Room, Integer> implements RoomService {

    @Autowired
    public RoomServiceImpl(JpaRepository<Room, Integer> repository) {
        super(repository);
    }

    @Override
    public Room getByName(String name) {
        return ((RoomRepository)repository).findByName(name);
    }
}
