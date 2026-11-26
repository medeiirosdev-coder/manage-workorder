package com.medeiros.os.controller;


import com.medeiros.os.dto.equipment.EquipmentRequestDTO;
import com.medeiros.os.dto.equipment.EquipmentResponseDTO;
import com.medeiros.os.service.EquipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("/equipments")
    public ResponseEntity<List<EquipmentResponseDTO>> findAll(){

        return ResponseEntity.ok(equipmentService.findAll());

    }

    @GetMapping("/equipment/{code}")
    public ResponseEntity<EquipmentResponseDTO> findEquipment(@PathVariable String code){

        return ResponseEntity.ok(equipmentService.findEquipment(code));

    }

    @PostMapping("/equipment")
    public ResponseEntity<EquipmentResponseDTO> createEquipment(@RequestBody @Valid EquipmentRequestDTO requestDTO){

        return ResponseEntity.ok(equipmentService.createEquipment(requestDTO));


    }


}
