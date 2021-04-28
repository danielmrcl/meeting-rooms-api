package io.github.danielmrcl.meetingRooms.repository;

import io.github.danielmrcl.meetingRooms.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
