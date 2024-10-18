package com.example.gym.mapper;

import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.request.RoomRequest;
import com.example.gym.dto.response.GymResponse;
import com.example.gym.dto.response.RoomResponse;
import com.example.gym.entities.Gym;
import com.example.gym.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public Room toRoom(RoomRequest request) {
        if (request == null) {
            return null;
        } else {
            Room.RoomBuilder roomBuilder = Room.builder();
            roomBuilder.name(request.getName());
            roomBuilder.description(request.getDescription());
            roomBuilder.roomType(request.getRoomType());
            roomBuilder.capacity(request.getCapacity());
            return roomBuilder.build();
        }
    }

    public RoomResponse toRoomResponse(Room room) {
        if (room == null) {
            return null;
        } else {
            RoomResponse.RoomResponseBuilder response = RoomResponse.builder();
            response.name(room.getName());
            response.description(room.getDescription());
            response.roomType(room.getRoomType());
            response.capacity(room.getCapacity());
            response.id(room.getId());
            return response.build();
        }
    }

    public void updateRoom(Room room, RoomRequest request) {
        if (request != null) {
            room.setName(request.getName());
            room.setDescription(request.getDescription());
            room.setRoomType(request.getRoomType());
            room.setCapacity(request.getCapacity());
            room.setId(room.getId());
        }
    }
}
