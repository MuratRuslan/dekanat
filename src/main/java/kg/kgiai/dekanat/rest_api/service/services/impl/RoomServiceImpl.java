package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Room;
import kg.kgiai.dekanat.rest_api.repository.RoomRepository;
import kg.kgiai.dekanat.rest_api.service.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Integer id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Room getByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public void save(Room object) {
        roomRepository.save(object);
    }

    @Override
    public void save(Iterable<Room> iterable) {
        roomRepository.save(iterable);
    }

    @Override
    public void delete(Iterable<Room> iterable) {
        roomRepository.delete(iterable);
    }

    @Override
    public void delete(Integer id) {
        roomRepository.delete(id);
    }
}
