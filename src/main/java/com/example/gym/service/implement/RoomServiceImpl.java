package com.example.gym.service.implement;

import com.example.gym.dto.request.RoomRequest;
import com.example.gym.dto.response.RoomResponse;
import com.example.gym.entities.Room;
import com.example.gym.mapper.RoomMapper;
import com.example.gym.repositories.RoomRepository;
import com.example.gym.service.RoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;

    @Override
    public RoomResponse createRoom(RoomRequest roomRequest) {
        Room room = roomMapper.toRoom(roomRequest);
        return roomMapper.toRoomResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse updateRoom(RoomRequest roomRequest, Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(()-> new RuntimeException("Room not found"));
        roomMapper.updateRoom(room, roomRequest);
        return roomMapper.toRoomResponse(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public RoomResponse getRoomById(Integer id) {
        return roomMapper.toRoomResponse(roomRepository
                .findById(id).orElseThrow(()-> new RuntimeException("Room not found")));
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::toRoomResponse)
                .toList();
    }
}
