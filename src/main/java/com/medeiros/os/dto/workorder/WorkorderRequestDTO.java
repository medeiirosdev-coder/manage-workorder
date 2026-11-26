package com.medeiros.os.dto.workorder;

import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.enums.Priority;
import com.medeiros.os.enums.Status;


public record WorkorderRequestDTO(String title, String description, Priority priority, Status status, Equipment equipment) {
}
