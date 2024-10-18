package com.example.gym.controllers;

import com.example.gym.dto.request.RoomRequest;
import com.example.gym.dto.response.ApiResponse;
import com.example.gym.dto.response.RoomResponse;
import com.example.gym.service.RoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomController {
    RoomService roomService;

    @PostMapping("/create")
    ApiResponse<RoomResponse> createRoom(@RequestBody RoomRequest roomRequest) {
        return ApiResponse.<RoomResponse>builder()
                .code(200)
                .result(roomService.createRoom(roomRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<RoomResponse> updateRoom(@RequestBody RoomRequest roomRequest, @PathVariable Integer id) {
        return ApiResponse.<RoomResponse>builder()
                .code(200)
                .result(roomService.updateRoom(roomRequest,id))
                .build();

    }

    @GetMapping
    ApiResponse<List<RoomResponse>> getAllRooms() {
        return ApiResponse.<List<RoomResponse>>builder()
                .code(200)
                .result(roomService.getAllRooms())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<RoomResponse> getRoomById(@PathVariable Integer id) {
        return ApiResponse.<RoomResponse>builder()
                .code(200)
                .result(roomService.getRoomById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteRoomById(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Delete successfully")
                .build();
    }

}
