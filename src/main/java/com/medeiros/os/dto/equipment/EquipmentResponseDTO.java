package com.medeiros.os.dto.equipment;

import java.util.UUID;

public record EquipmentResponseDTO(UUID id, String code, String name, String local, Boolean active) {
}
