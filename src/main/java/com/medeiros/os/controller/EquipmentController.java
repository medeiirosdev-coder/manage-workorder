package com.medeiros.os.controller;


import com.medeiros.os.dto.equipment.EquipmentRequestDTO;
import com.medeiros.os.dto.equipment.EquipmentResponseDTO;
import com.medeiros.os.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;


    @PostMapping("/equipamentos")
    public ResponseEntity<EquipmentResponseDTO> createEquipment(EquipmentRequestDTO requestDTO){

        return ResponseEntity.ok(equipmentService.createEquipment(requestDTO));


    }


}
