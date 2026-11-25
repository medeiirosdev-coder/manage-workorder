package com.medeiros.os.repository;

import com.medeiros.os.domain.workorder.Workorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkorderRepository extends JpaRepository<Workorder, UUID> {
}
