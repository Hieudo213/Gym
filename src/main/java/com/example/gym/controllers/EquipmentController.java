package com.example.gym.controllers;

import com.example.gym.dto.request.EquipmentRequest;
import com.example.gym.dto.response.ApiResponse;
import com.example.gym.dto.response.EquipmentResponse;
import com.example.gym.service.EquipmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EquipmentController {
    EquipmentService equipmentService;

    @PostMapping("/create")
    ApiResponse<EquipmentResponse> createEquipment(@RequestBody EquipmentRequest request){
        return ApiResponse.<EquipmentResponse>builder()
                .code(200)
                .result(equipmentService.createEquipment(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<EquipmentResponse> updateEquipment(@PathVariable("id") Integer id, @RequestBody EquipmentRequest request){
        return ApiResponse.<EquipmentResponse>builder()
                .code(200)
                .result(equipmentService.updateEquipment(request, id))
                .build();
    }

    @GetMapping
    ApiResponse<List<EquipmentResponse>> getAllEquipment(){
        return ApiResponse.<List<EquipmentResponse>>builder()
                .code(200)
                .result(equipmentService.getAllEquipment())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<EquipmentResponse> getEquipmentById(@PathVariable("id") Integer id){
        return ApiResponse.<EquipmentResponse>builder()
                .code(200)
                .result(equipmentService.getEquipmentById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Delete successfully!")
                .build();
    }
}
