package com.medeiros.os.dto.workorder;


import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.enums.Priority;
import com.medeiros.os.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record WorkorderResponseDTO(UUID id, String title, String description, Priority priority, Status status, Equipment equipment, LocalDateTime createdAt, LocalDateTime closedAt) {
}
