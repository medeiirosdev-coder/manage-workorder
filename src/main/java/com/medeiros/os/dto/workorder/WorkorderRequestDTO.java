package com.medeiros.os.dto.workorder;

import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.enums.Priority;
import com.medeiros.os.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record WorkorderRequestDTO(
        @NotBlank(message = "Title is required") String title,
        @NotBlank(message = "Description is required")String description,
        @NotNull(message = "Priority is required") Priority priority,
        @NotNull(message = "Equipment Code is required") String equipmentCode
) {
}
