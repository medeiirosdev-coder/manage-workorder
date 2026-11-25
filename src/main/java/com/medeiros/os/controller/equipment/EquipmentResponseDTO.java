package com.medeiros.os.controller.equipment;

import java.util.UUID;

public record EquipmentResponseDTO(UUID id, String code, String name, String local, Boolean active) {
}
