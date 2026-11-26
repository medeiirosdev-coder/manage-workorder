package com.medeiros.os.dto.equipment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipmentRequestDTO (
        @NotBlank(message = "Code is required") String code,
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Local is required") String local,
        @NotNull(message = "Active is required") Boolean active) {
}
