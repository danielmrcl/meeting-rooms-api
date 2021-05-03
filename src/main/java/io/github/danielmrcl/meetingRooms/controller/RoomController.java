package io.github.danielmrcl.meetingRooms.controller;

import io.github.danielmrcl.meetingRooms.exceptions.ResourceNotFoundException;
import io.github.danielmrcl.meetingRooms.model.Room;
import io.github.danielmrcl.meetingRooms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @GetMapping
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room "+id+" not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) throws ResourceNotFoundException {
        repository.delete(getRoomById(id));
    }

    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable Long id) throws ResourceNotFoundException {
        Room roomEntity = getRoomById(id);
        roomEntity.setName(room.getName());
        roomEntity.setDate(room.getDate());
        roomEntity.setStartHour(room.getStartHour());
        roomEntity.setEndHour(room.getEndHour());
        return repository.save(roomEntity);
    }
}
