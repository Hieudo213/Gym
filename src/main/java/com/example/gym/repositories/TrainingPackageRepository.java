package com.example.gym.repositories;

import com.example.gym.entities.TrainingPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPackageRepository extends JpaRepository<TrainingPackage, Integer> {
}
