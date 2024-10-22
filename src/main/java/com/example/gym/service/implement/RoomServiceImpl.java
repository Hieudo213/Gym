package com.example.gym.service.implement;

import com.example.gym.dto.request.RoomRequest;
import com.example.gym.dto.response.RoomResponse;
import com.example.gym.entities.Equipment;
import com.example.gym.entities.Room;
import com.example.gym.exception.ApplicationException;
import com.example.gym.exception.ErrorCode;
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
        Room room = roomRepository.findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND));
        roomMapper.updateRoom(room, roomRequest);
        return roomMapper.toRoomResponse(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND));
        roomRepository.deleteById(id);
    }

    @Override
    public RoomResponse getRoomById(Integer id) {
        return roomMapper.toRoomResponse(roomRepository
                .findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND)));
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();

        if (rooms.isEmpty()) {
            throw new ApplicationException(ErrorCode.LIST_EMPTY);
        }

        return rooms.stream()
                .map(roomMapper::toRoomResponse)
                .toList();
    }
}
