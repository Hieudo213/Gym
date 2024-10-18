package com.example.gym.controllers;

import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.response.ApiResponse;
import com.example.gym.dto.response.GymResponse;
import com.example.gym.service.GymService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class GymController {
    GymService gymService;

    @PostMapping("/create")
    ApiResponse<GymResponse> createUser(@RequestBody @Valid GymRequest request) {
        return ApiResponse.<GymResponse>builder()
                .code(200)
                .result(gymService.createGym(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<GymResponse> updateUser(@RequestBody @Valid GymRequest request, @PathVariable Integer id) {
        return ApiResponse.<GymResponse>builder()
                .code(200)
                .result(gymService.updateGym(request, id))
                .build();
    }

    @GetMapping
    ApiResponse<List<GymResponse>> getAllGyms() {
        return ApiResponse.<List<GymResponse>>builder()
                .code(200)
                .result(gymService.getAllGyms())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<GymResponse> getGymById(@PathVariable Integer id) {
        return ApiResponse.<GymResponse>builder()
                .code(200)
                .result(gymService.getGymById(id))
                .build();

    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteGym(@PathVariable Integer id) {
        gymService.deleteGymById(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Delete successfully!")
                .build();
    }
}
