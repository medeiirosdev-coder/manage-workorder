package com.medeiros.os.repository;

import com.medeiros.os.domain.equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {

    boolean existsByCode(String code);
    Optional<Equipment> findByCode(String code);
}
