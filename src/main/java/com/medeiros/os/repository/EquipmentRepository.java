package com.medeiros.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<EquipmentRepository, UUID> {
}
