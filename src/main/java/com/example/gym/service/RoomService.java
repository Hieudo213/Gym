package com.example.gym.service;

import com.example.gym.dto.request.RoomRequest;
import com.example.gym.dto.response.RoomResponse;

import java.util.List;

public interface RoomService {
    RoomResponse createRoom(RoomRequest roomRequest);
    RoomResponse updateRoom(RoomRequest roomRequest, Integer id);
    void deleteRoom(Integer id);
    RoomResponse getRoomById(Integer id);
    List<RoomResponse> getAllRooms();
}
