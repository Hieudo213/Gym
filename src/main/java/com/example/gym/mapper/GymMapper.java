package com.example.gym.mapper;

import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.response.GymResponse;
import com.example.gym.entities.Gym;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {
    public Gym toGym(GymRequest request) {
        if (request == null) {
            return null;
        } else {
            Gym.GymBuilder gym = Gym.builder();
            gym.name(request.getName());
            gym.location(request.getLocation());
            gym.description(request.getDescription());
            gym.roomNumber(request.getRoomNumber());
            return gym.build();
        }
    }

    public GymResponse toGymResponse(Gym gym) {
        if (gym == null) {
            return null;
        } else {
            GymResponse.GymResponseBuilder response = GymResponse.builder();
            response.name(gym.getName());
            response.description(gym.getDescription());
            response.roomNumber(gym.getRoomNumber());
            response.location(gym.getLocation());
            response.id(gym.getId());
            return response.build();
        }
    }
    public void updateGym(Gym gym, GymRequest request) {
        if (request != null) {
            gym.setName(request.getName());
            gym.setDescription(request.getDescription());
            gym.setRoomNumber(request.getRoomNumber());
            gym.setId(gym.getId());
            gym.setLocation(request.getLocation());
        }
    }
}
